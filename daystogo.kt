
/* # Filename: daystogo.kt */

// ******************************************************************
// ***
// ***   Author: David Billsbrough 
// ***  Created: Sunday, August 18, 2024 at 18:22:44 PM (EDT)
// ***  License: GNU General Public License -- version 2
// ***  Version: $Revision: 0.6 $
// *** Warranty: None
// ***  Purpose: Calculate the difference in days between two dates
// ***
// ******************************************************************  

// $Id: daystogo.tcl,v 0.6 2024/08/19 18:45:08 kc4zvw Exp kc4zvw $

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
	val my_date = ""

    var newdate = "2024-08-23T12:41:12";

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

// ------------------------------

fun get_home_dir() : String {

	val myHOME = (System.getenv("HOME") ?: "").ifEmpty { "/home/kc4zvw" }
	
	val formatted = ("My \$HOME directory is $myHOME.\n")
	println(formatted)

	return "$myHOME"
}

fun process_line( eventDate : String, eventName : String ) {

	var answer = "$eventDate" + ":" + "$eventName"
	println( "Result: $answer" )

	val dayCount = calc_dates( eventDate )
	var daycount = -4
	output_display( eventName )
}

fun output_display( event_name: String ) {

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

	val fmt1 = "%s"
	val fmt2 = "%D"
	val fmt3 = "%Y/%m/%d"

	//global Now

	// println("Received: $Date0")
	// val Tgt = String.range( $Date0, 2, end - 1)
	var Tgt: String = "yyyy/mm/dd"
	// println("Changed to: $Tgt")

	//val Target1 [clock scan $Tgt -format $fmt3]
	//val Today [clock format $Now -format $fmt1]
	val Target1: Long = 0
	val Today: Long = 1

	// println( "var Now is $Now")
	// println( "var Today is $Today")
	// println( "var Target is $Target1")

	val numDays1: Long  = Today / 86400
	val numDays2: Long  = Target1 / 86400
	//val deltaDays: Int = (numDays2.toInt - numDays1.toInt)
	val deltaDays: Int = -3

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

//  Notes: ((getenv "HOME") or "/home/kc4zvw") sep ".calendar"))

fun set_epoch_time(): Long {

	//global Now

	//val Now [clock seconds]
	return 999999
}

// Open text file for reading

fun withOpenFile( filename: String, channelVar: Int, script: String ) {

	//upvar 1 $channelVar chan
	//val chan [open $filename]
	//catch {
        //uplevel 1 $script
	// } result options
	//close $chan
	//return -options $options $result
}

// ##  Notes:  set infile [open $calendarFile {RDONLY EXCL}] 
// #			println(format ["Couldn't open %s for reading dates.\n"] calendar-file
// #			exit 2 


// --------------------- 

//  do main loop though the calendar file

fun readFileAsLinesUsingReadLines(fileName: String): List<String> 
	= File(fileName).readLines()

fun first_loop() {

	val fileName = build_path_name()

	var List3 = readFileAsLinesUsingReadLines(fileName)

	// println (List3)

	for (line in List3) {
		// println("Read line: $line")
	
		var part1 = line.substring( 0, 10 )
		var part2 = line.substring( 11 )

		// println("part1=$part1 : part2=$part2")

		process_line(part1, part2)
	}
}

fun search_for_comments() {
	//	let ((m (string-match "^[ \t]*#" line)))
	//	if m (format #t "comment: ~a\n" line)))
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
