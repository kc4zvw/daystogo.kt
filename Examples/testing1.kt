//
// $Id:$
//

import kotlin.math.abs


// Setup global variables and constants

val calendar_file = ".calendar"
val os_sep = "/"

val Now = 13				/* a epoch time from a long time ago */

val spaces = "." 
val event_date = spaces.repeat(20)				// # working register 1
val event_name = spaces.repeat(60)				// # working register 2

val Answer = spaces.repeat(80)					// # allocate a 80 byte string
val dayCount = 0


fun build_path_name(): String {

	val myhome = get_home_dir()
	val path_name = "$myhome$os_sep$calendar_file"
	val fmt = "Filename: $path_name"

	println( "$fmt" )

	return "$path_name"
}

// ------------------------------

fun get_home_dir() : String {

	val myHOME = (System.getenv("HOME") ?: "").ifEmpty { "/home/kc4zvw" }
	
	val formatted = ("My \$HOME directory is $myHOME.\n")
	println("$formatted")

	return "$myHOME"
}


fun display_banner() {

	val Today = "@@@@@"
	val fmt = "%A, %B %d, %y at %H:%M:%S (%Z)"
	val str2 = "  Today's date is $Today.\n"
	val dash = "="
	val dashes = dash.repeat(60)

	//global Now

	//val Today [clock format $Now -format $fmt]

	println("Days To Go Calculator (Kotlin version)")
	println()
	println("$dashes")
	println()
	println("$str2")
	println("$dashes")
	println()
}

fun main_routine() {
	//println("Hello world!")
	display_banner()
	val result = build_path_name()

	println("$result")
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

