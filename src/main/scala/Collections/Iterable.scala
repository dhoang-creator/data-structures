package Collections

/*
  Note that Iterable sits atop the collection hierarchy
    - The below methods apply to both 'Iterable' and 'Traversable', so no need to duplicate
 */

trait Iterable[A] {

  def iterator: Iterator[A] = ???

  // Operations
  xs.foreach(f)         // Executes function f for every element of xs
  xs.grouped(size)      // An iterator that yields fixed-sized "chunks" of this collection
  xs.sliding(size)      // An iterator that yields a sliding fixed sized window

  // Addition
  xs.concat(ys) || xs ++ ys

  // Maps
  xs.map(f)             // A collection is obtained from applying the function f to every element in xs
  xs.flatMap(f)         // A collection is obtained from applying the collection-valued function f to every element in xs and then concatenating the result


}
