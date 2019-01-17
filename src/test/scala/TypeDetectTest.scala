import org.specs2.mutable._
import com.github.tototoshi.csv._
import java.io._

class  TypeDetectTest extends Specification {

  //the mehtod had already been written that enable reading dsta from csv. that is the smae one that was sent through the chat

  //get the daat to read from an external file


  //count integer method works but it needs to read all data. it's only reading one line.

  //reader.all() - doesnt seem to work



  // all i need to do is figure out how to read the csv files correctly other wise the tests seem to be working

  "The Type Detector" should {

    "Count Integers" >> {

      val reader = CSVReader.open(new File("C:\\Users\\mercy\\Documents\\GitHub\\typeDetect\\src\\test\\scala\\test_data\\int_test.csv"))
//
//      reader.all()
//
//      reader.close()

      val countInt = reader.iterator
      dataTypeDetect.findAllTypes(
        countInt.next()

      ) must be havePair("Integer" -> 2)
    }

   "Recognize Integers" >> {

      val reader = CSVReader.open(new File("C:\\Users\\mercy\\Documents\\GitHub\\typeDetect\\src\\test\\scala\\test_data\\int_test.csv"))

      val intReader = reader.iterator
      dataTypeDetect.guessType(
        intReader.next()

      ) must be equalTo("Integer")
    }

    /*
   "Recognize Floats" >> {

     val reader = CSVReader.open(new File("C:\\Users\\mercy\\Documents\\GitHub\\typeDetect\\src\\test\\scala\\test_data\\bigFloatFile.csv"))

     val floatReader = reader.iterator
     dataTypeDetect.guessType(

     floatReader.next()

     ) must be equalTo("Float")

   }

   "Recognize Dates" >> {

     val reader = CSVReader.open(new File("C:\\Users\\mercy\\Documents\\GitHub\\typeDetect\\src\\test\\scala\\test_data\\zs.csv"))

     val dateReader = reader.iterator

     dataTypeDetect.guessType(
      dateReader.next()
     ) must be equalTo("Date")
   }


   "Recognize Strings" >> {

     val reader = CSVReader.open(new File("C:\\Users\\mercy\\Documents\\GitHub\\typeDetect\\src\\test\\scala\\test_data\\cpuspeed.csv"))

     val stringReader = reader.iterator

     dataTypeDetect.guessType(

       stringReader.next()

     ) must be equalTo("String")

   }*/

  }
}