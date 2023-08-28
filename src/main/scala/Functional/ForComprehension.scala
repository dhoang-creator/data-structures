package Functional

object Company {

  case class Customer(value: Int)
  case class Consultant(portfolio: List[Customer])
  case class Branch(consultants: List[Consultant])
  case class Company(branches: List[Branch])

  /*
  If we were to attempt to break down the below for comprehension, it would be as follows:
  for {
                      create a List "for all the branches"    from the "All Company Branches List"                    and call it "branch"
    then              create a List "for all the consultants" from the "All Company Branches Consultants List"        and call it "consultant"
    then              create a List "for all the customers"   from the "All Company Branches Consultants Portfolios"  and call it "customer"
    then map that     all the customers                       and yield it as {customer.value}

   */
  def getCompanyValue(company: Company): Int = {

    // could we simply use the comments to work this one out if we just know about flatMap and map and the bounded constraints
    val valuesList = for {
      branch <- company.branches // -> new List of each companies branches
      consultant <- branch.consultants // -> new List of each of the above companies branches consultants
      customer <- consultant.portfolio // -> new List of the companies branches consultants portfolios
    } yield (customer.value) // but how do we get to the customer values?

    valuesList reduce (_ + _)
  }
}