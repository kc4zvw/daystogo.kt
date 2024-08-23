//
//
//

/* # Filename: testing3.kt */

// ******************************************************************
// ***
// ***   Author: David Billsbrough 
// ***  Created: Thursday, August 22, 2024 at 21:41:16 PM (EDT)
// ***  Version: $Revision:$
// ***
// ******************************************************************  

// $Id:$

import java.io.File
import kotlin.math.abs
// import kotlin.time

val calendar_file = ".calendar"
val os_sep = '/'

// val Now = Duration.inSeconds


//  do main loop though the calendar file

fun readFileAsLinesUsingReadLines(fileName: String): List<String> 
	= File(fileName).readLines()

fun first_loop() {

	var fullline: String = ""

	val fileName = build_path_name()

	// val List2 = listOf( "Alpha", "Bravo", "Charlie", "Delta", "Echo" )

	// println()
	// for (x in List2) {
	//  	println (x)
	// }
	// println()

	var List3 = readFileAsLinesUsingReadLines(fileName)

	println()
	println (List3)
	println()

	for (line in List3) {
		println("Read line: $line")
		fullline = line
	}
	println()

	var part1 = fullline.substring( 0, 10 )
	var part2 = fullline.substring( 11 )

	println("part1=$part1 : part2=$part2")
}

fun display_banner() {

	val Today = "$$$$$"

	val fmt = "%A, %B %d, %y at %H:%M:%S (%Z)"
	val textfmt = "  Today's date is $Today.\n"
	val dash = "="
	val dashes = dash.repeat(60)

	// global Now

	// val Today [clock format $Now -format $fmt]

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
	val fmt = "Filename: $path_name"

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
	println("End of Report")
}

/* End of file */
