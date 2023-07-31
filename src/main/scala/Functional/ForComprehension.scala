package Functional

/*
  In order to better understand the breakdown of the 'For Comprehension':
    1. We first have to understand the difference between 'map' and 'flatMap' within the Scala Ecosystem
      def map(f: A => B): M[B] --> applies a transformation of the monad 'content' but maintaining the monad's "external shape"
      def flatMap(f: A => M[B]): M[B] --> applies a transformation of the monad 'content' but through composition, results in another monad instance of the same type
    2. We have to differentiate between for expressions with only one operation vs multiple
    3. Understand that for is just a composition of successive monads, which must be "flattened" to maintain a single "external shape"
 */

object Company {

  case class Customer(value: Int)

  case class Consultant(portfolio: List[Customer])

  case class Branch(consultants: List[Consultant])

  case class Company(branches: List[Branch])

  /*
  We need to break down the below utilising the information we already have:
    List[Branches].flatMap { List[Consultant] =>
      Branch.flatMap { Consultant[Portfolio] =>
        Consultant.map { customer =>
          customer.value }

   */
  def getCompanyValue(company: Company): Int = {

    // could we simply use the comments to work this one out if we just know about flatMap and map and the bounded constraints
    val valuesList = for {
      branch      <- company.branches       // -> new List of each companies branches
      consultant  <- branch.consultants     // -> new List of each of the above companies branches consultants
      customer    <- consultant.portfolio   // -> new List of the companies branches consultants portfolios
    } yield (customer.value)                // but how do we get to the customer values?

    valuesList reduce (_ + _)
  }

  def mkMatcher(pat: String): Option[String => Boolean] =
    pattern(pat) map (p => (s: String) => p.matcher(s).matches)

  def bothMatch(pat: String, pat2: String, s: String): Option[Boolean] = for {
    f <- mkMatcher(pat)
    g <- mkMatcher(pat2)
  } yield f(s) && g(s)
}



object For {

  /*
    1. Each line in the expression using '<-' is flatMap aside from the last line which is a map call
   */

  // the following ...
  for {
    bound <- list
    out <- f(bound)
  } yield out

  // ... is translated by the Scala compiler as ...
  list.flatMap { bound =>
    f(bound).map { out =>
      out
    }
  }

  // ... which can be simplified as ...
  list.flatMap { bound =>
    f(bound)
  }

  // ... which is just another way of writing:
  list flatMap f

  /*
    2. A singular for expression is simply another way of utilising map
   */
  // The following ...
  for {
    bound <- list
  } yield f(bound)

  // ... is translated by the Scala compiler as ...
  list.map { bound =>
    f(bound)
  }

  // ... which is just another way of writing:
  list map f

}