import org.specs2.mutable._

class TypeDetectTest extends Specification {

  "The Type Detector" should {

    "Count Integers" >> {
      dataTypeDetect.findAllTypes(
        Seq("1", "2", "3", "500", "29", "50.0000")

        //Seq(rating.csv)
      ) must be havePair("Integer" -> 5)
    }

    "Recognize Integers" >> {
      dataTypeDetect.guessType(
        Seq("1", "2", "3", "500", "29", "50")

        //Seq(bigFloatFile.csv)
      ) must be equalTo("Integer")
    }
    "Recognize Floats" >> {
      dataTypeDetect.guessType(
        Seq("1.0", "2.0", "3.2", "500.1", "29.9", "50.0000")

        //Seq(cpuspeed.csv)

      ) must be equalTo("Float")

      dataTypeDetect.guessType(
        Seq("1", "2", "3", "500", "29", "50.0000")
      ) must be equalTo("Float")
    }

    "Recognize Dates" >> {
      dataTypeDetect.guessType(
        Seq("1984-11-05", "1951-03-23", "1815-12-10")
      ) must be equalTo("Date")
    }
    "Recognize Strings" >> {
      dataTypeDetect.guessType(
        Seq("Alice", "Bob", "Carol", "Dave")
      ) must be equalTo("String")
      dataTypeDetect.guessType(
        Seq("Alice", "Bob", "Carol", "1", "2.0")
      ) must be equalTo("String")
    }

  }
}