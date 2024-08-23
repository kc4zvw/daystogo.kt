
/* # Filename: testing3.kt */

// ******************************************************************
// ***
// ***   Author: David Billsbrough 
// ***  Created: Thursday, August 22, 2024 at 21:41:16 PM (EDT)
// ***  Version: $Revision: 0.6 $
// ***
// ******************************************************************  

// $Id: testing3.kt,v 0.6 2024/08/23 15:09:26 kc4zvw Exp kc4zvw $

import java.io.File
import java.time.*
import java.time.format.*
import java.time.format.DateTimeFormatter.*
import java.time.format.DateTimeFormatterBuilder.*
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.math.abs
import kotlin.time.*

val calendar_file = ".calendar"
val os_sep = '/'

//val Now: Duration = 5.seconds
val unixTime = System.currentTimeMillis() / 1000
val localDate: LocalDate = LocalDate.now();

val zoneId: ZoneId = ZoneId.of("America/New_York")
val now: LocalDate = LocalDate.now(zoneId)
val epochMilli: Long = ZonedDateTime.of(LocalDate.now(zoneId).atTime(12, 0, 0, 999 * 1000 * 1000),
    zoneId).toInstant().toEpochMilli()
val unixEpocSeconds: Long = epochMilli % (24 * 60 * 60 * 1000)		 // secs per day: 86400


//  do main loop though the calendar file

fun readFileAsLinesUsingReadLines(fileName: String): List<String> 
	= File(fileName).readLines()

fun first_loop() {

	val fileName = build_path_name()

	// val List2 = listOf( "Alpha", "Bravo", "Charlie", "Delta", "Echo" )

	// println()
	// for (x in List2) {
	//  	println (x)
	// }
	// println()

	var List3 = readFileAsLinesUsingReadLines(fileName)

	// println (List3)

	for (line in List3) {
		println("Read line: $line")
		println()

		var part1 = line.substring( 0, 10 )
		var part2 = line.substring( 11 )

		// println("part1=$part1 : part2=$part2")
	}
}

fun formattedDate( d : Long ) : String {

	//val my_date: String = strftime("%A, %B %d, %Y at %H:%M:%S", localtime(d))
	val my_date: String = "*Unknown*"

	val myDateObj: LocalDateTime = LocalDateTime.now()
    println("Before formatting: $myDateObj")
	val myFormatObj: DateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy 'at' HH:mm:ss a");
    val formattedDate: String = myDateObj.format(myFormatObj)
    println("After formatting: $formattedDate")

    return "$formattedDate"
}

fun formattedDate2( d : Long ) : String {

	val formatter: DateTimeFormatter = ISO_LOCAL_DATE

	val date: LocalDate = LocalDate.now()
	val text: String = date.format(formatter)
	val parsedDate: LocalDate = LocalDate.parse(text, formatter)

	return "$parsedDate"
}


fun formattedDate3( d : Long ) : String {

	val formatter1: DateTimeFormatter = ISO_DATE
	val formatter2: DateTimeFormatter = ISO_TIME

	val date: LocalDate = LocalDate.now()
	val time: LocalTime = LocalTime.now()

	var str: String = "January 2, 2024"
	var parsedDate: String = "" 

	try {
		val formatter: DateTimeFormatter = DateTimeFormatter.RFC_1123_DATE_TIME
		val date0: LocalDate = LocalDate.parse(str, formatter);
		val text: String = date0.format(formatter)
		val parsedDate: LocalDate = LocalDate.parse(text, formatter)
	}

	catch (e: Exception) {
		parsedDate = "00-00-0000" 
	}


	return "$parsedDate"
}

//	return time.strftime("%A, %B %d, %Y at %H:%M:%S", time.localtime(d))

fun formattedDate4( d : Long ) : String {

    var newdate = "2024-08-23T12:41:12";

 //   try {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

        //formatter.timeZone = TimeZone.getTimeZone("EDT")
        val value = formatter.parse(newdate.toString())
        val dateFormatter = SimpleDateFormat("EEEEE, MMMMM dd, yyyy 'at' hh:mma (z)") //this format changeable
        //dateFormatter.timeZone = TimeZone.getDefault()
        newdate = dateFormatter.format(value)


//	} catch (e: Exception) {
//		newdate = "00-00-0000 00:00"
//	}

	return "$newdate"
}

fun display_banner() {

	val Today: String = formattedDate4(unixEpocSeconds)

	val textfmt = "  Today's date is $Today.\n"
	val dash = "="
	val dashes = dash.repeat(60)

	println("Days To Go Calculator (Kotlin version)")
	println()
	println("$dashes")
	println()
	println("$textfmt")
	println("$dashes")
	println()
}

fun get_home_dir() : String {

	val myHOME = (System.getenv("HOME") ?: "").ifEmpty { "/home/kc4zvw" }
	
	val formatted = ("My \$HOME directory is $myHOME.\n")
	println(formatted)

	return "$myHOME"
}

fun build_path_name() : String {

	val myhome = get_home_dir()
	val path_name = "$myhome$os_sep$calendar_file"
	val fmt = "Filename: $path_name\n"

	println( "$fmt" )

	return "$path_name"
}


fun output_display( event_name: String ) {

	println()
	println("The parameter is $event_name")
	println()

	val dayCount: Int = -4

	// val corrected = String.range( $eventName, 1, end - 2)
	val corrected: String = "$event_name"
	val eventName: String = "$corrected"
	val absolute_value: Int = abs(dayCount)

	println("The count is $dayCount")
	println("The name is $eventName")
	
	if ( dayCount <= -2 ) {
		val format = "It was $absolute_value days ago since $eventName."
		println("$format")
	} else if ( dayCount == -1 ) {
		val format = ("Yesterday was $eventName.")
		println("$format")
	} else if ( dayCount == 0 ) {
		val format = "Today is $eventName."
		println("$format")
	} else if ( dayCount == 1 ) {
		val format = "Tomorrow is $eventName."
		println("$format")
	} else if ( dayCount >= 2 ) {
		val format = "There are $dayCount days until $eventName."
		println("$format")
	} else {
		val format = "No Match for $eventName.\n"
		println("$format")
	}
}


fun main() {
	display_banner()
	first_loop()

	println()
	println(" unixTime = $unixTime")
	println(" localDate = $localDate")
	println(" unixEpocSeconds = $unixEpocSeconds")
	println()
	println( formattedDate(unixTime))
	println( formattedDate2(unixTime))
	println( formattedDate3(unixTime))
	println( formattedDate4(unixTime))
	println()
	println("End of Report")
}

/* End of file */
