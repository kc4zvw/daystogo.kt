
/* # Filename: daystogo.kt */

// ******************************************************************
// ***
// ***   Author: David Billsbrough 
// ***  Created: Sunday, August 18, 2024 at 18:22:44 PM (EDT)
// ***  License: GNU General Public License -- version 2
// ***  Version: $Revision: 0.42 $
// *** Warranty: None
// ***
// ***  Purpose: Calculate the difference in days between two dates
// ***
// ******************************************************************  

// $Id: daystogo.kt,v 0.42 2024/08/24 00:48:27 kc4zvw Exp kc4zvw $

import java.io.File
import java.text.SimpleDateFormat
import java.time.*
import java.time.format.*
import java.time.format.DateTimeFormatter.*
import java.time.format.DateTimeFormatterBuilder.*
import java.util.Date
import kotlin.math.abs
import kotlin.math.truncate
import kotlin.time.*


// Setup global variables and constants

val calendar_file = ".calendar"
val os_sep = "/"

val Now: Long = 13				/* a epoch time from a long time ago */

val unixTime = System.currentTimeMillis() / 1000
val localDate: LocalDate = LocalDate.now();

val spaces = "." 
val event_date = spaces.repeat(20)				// # working register 1
val event_name = spaces.repeat(60)				// # working register 2
val Answer = spaces.repeat(80)					// # allocate a 80 byte string

val dayCount = 0

// ------------------------------

//fun as_days( secs : Float ) : Long {
//	val temp = secs / 86400
//	val ans: Long = truncate(temp)
//	return ans
//}

fun date_to_secs( str : String ) : String {
	//return mktime (strptime "%Y/%m/%d" str)
	return ""
}

fun formattedDate( d : Long ) : String {

	var newdate = "2024-08-23T12:41:12";
	val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

	//formatter.timeZone = TimeZone.getTimeZone("EDT")
	val value = formatter.parse(newdate.toString())
	val dateFormatter = SimpleDateFormat("EEEEE, MMMMM dd, yyyy 'at' hh:mma (z)") //this format changeable
	//dateFormatter.timeZone = TimeZone.getDefault()
	newdate = dateFormatter.format(value)

	return "$newdate"
}

// ------------------------------

//  Notes: ((getenv "HOME") or "/home/kc4zvw")

fun get_home_dir() : String {

	val myHOME = (System.getenv("HOME") ?: "").ifEmpty { "/home/kc4zvw" }
	
	val formatted = ("My \$HOME directory is $myHOME.\n")
	println(formatted)

	return "$myHOME"
}

fun process_line( eventDate : String, eventName : String ) {

	var answer = "$eventDate" + ":" + "$eventName"
	// println( "Result: $answer" )

	var dayCount = calc_dates( eventDate )

	output_display( dayCount, eventName )
}

fun output_display( dayCount: Int, event_name: String ) {

	val corrected: String = "$event_name"
	val eventName: String = "$corrected"
	val absolute_value: Int = abs(dayCount)

	// println("The count is $dayCount")
	// println("The name is $eventName")
	
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

// ------------------------------

//  set Zone eval (0500 +1)			#-- not used now

fun diff ( num1: Int, num2: Int ) : Int {

	val ans: Int = num1 - num2

	return ans
}

fun calc_dates( Date0: String ) : Int {

	var Tgt: String = "yyyy/mm/dd"

	val dateString: String = "$Date0"
	val df: SimpleDateFormat = SimpleDateFormat("yyyy/MM/dd");
	// df.setTimeZone(TimeZone.getTimeZone("UTC"))
	val date: Date = df.parse(dateString)
	val time: Long = date.getTime()
	val target: Long = time / 1000

	val Target1: Long = target
	val Today: Long = unixTime

	val numDays1: Long  = Today / 86400
	val numDays2: Long  = Target1 / 86400
	val diff: Long = (numDays2 - numDays1)
	// println( "the difference is $diff" )
	val deltaDays: Int = diff.toInt()

	return deltaDays
}

// --------------------

fun display_banner() {

	val Today = formattedDate(unixTime)
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

fun build_path_name() : String {

	val myhome = get_home_dir()
	val path_name = "$myhome$os_sep$calendar_file"
	val fmt = "Filename: $path_name"

	println( "$fmt\n" )

	return "$path_name"
}


fun set_epoch_time(): Long {

	return 999999		// defined as a global for now (see above)
}

/* Open text file for reading */

fun withOpenFile( filename: String, channelVar: Int, script: String ) {

	//upvar 1 $channelVar chan
	//val chan [open $filename]
	//catch {
	//  uplevel 1 $script
	//} result options
	//close $chan
	//return -options $options $result
}

//  Notes:  set infile [open $calendarFile {RDONLY EXCL}] 
// 			println("Couldn't open $calendar-file for reading dates.\n")
// 			exit 2 


// --------------------- 

/* do main loop though the calendar file */

fun readFileAsLinesUsingReadLines(fileName: String): List<String> 
	= File(fileName).readLines()

fun first_loop() {

	val fileName = build_path_name()
	var List3 = readFileAsLinesUsingReadLines(fileName)

	for (line in List3) {
		// println("Read line: $line")
		var part1 = line.substring( 0, 10 )
		var part2 = line.substring( 11 )
		// println("part1=$part1 : part2=$part2")

		process_line(part1, part2)
	}
}

fun search_for_comments() {

	/* will write this part later! */

	// if a text line starts with a "#" it is a comment to be skipped over.
}

fun main_routine() {
	set_epoch_time()
	display_banner()
	first_loop()
}


//  ***----------------------------------***
//  **     Main program begins here       ** 
//  ***----------------------------------***

fun main() {
	main_routine()

	println()
	println("End of report")
}

// vim: syntax=kotlin tabstop=4 nowrap:

/* End of script */
