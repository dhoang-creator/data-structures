package Functional

import java.lang.IllegalArgumentException
import scala.annotation.tailrec

sealed trait Matching
final case class Match(word: String, wordListName: String) extends Matching
final case class WordList(name: String, words: List[String]) extends Matching

object Matching {

  // if we're including the params of the above case classes, do we need to contain them inside the furthest outside function signature?
  def matches(text: String): List[String] = {
    val textWords = splitWords(text)

    def splitWords(text: String): List[String] =
      text.split("\\s+").toList

    def findMatchingWords(textWords: List[String], words: List[String]): List[String] = {
      // are there issues with the below method call also?
      textWords.filter(w => words.contains(w.toLowerCase()))
    }

    // should the buck stop here in terms of what you want to do?

    def createMatches(name: String, matchingWords: List[String]): Option[List[String]] = for {
        // is it, we think that the below command is unpacking the List[String] into the individual Strings?
        mW <- matchingWords
        // the below is a Cat's Data Type which calls in the equivalency of the two arguments
        if eqv(name, mW)
          nameList = name.toList
        throw new IllegalArgumentException("there are no matches")
    } yield nameList

    def matchesWord(textWords: List[String], words: List[String], name: String): Option[List[String]] = {
      @tailrec
      // here, have we just plucked some of the method params from thin air i.e. words: List[String]

      // wait one second, shouldn't you be putting the data of both of the above case classes into the methods signature?
      def matchTextWord(textWords: List[String], words: List[String], name: String): Option[List[String]] = {
        textWords match {
          case name => for {
            mW <- findMatchingWords(textWords, words)
            tW <- createMatches(name, mW)
          } yield tW
        }
      }
      matchTextWord(textWords, words, name)
    }
  }
}
