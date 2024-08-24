
/* # Filename: testing4.kt */

// ******************************************************************
// ***
// ***   Author: David Billsbrough 
// ***  Created: Thursday, August 22, 2024 at 21:41:16 PM (EDT)
// ***  Version: $Revision:$
// ***
// ******************************************************************  

// $Id:$

import java.io.File
import java.text.SimpleDateFormat
import java.time.*
import java.time.format.*
import java.time.format.DateTimeFormatter.*
import java.time.format.DateTimeFormatterBuilder.*
import java.util.Date
import kotlin.math.abs
import kotlin.math.truncate

fun display_banner() {

	val Today: String = "@@@@@"
	val TextFmt: String = "Today's date is $Today.\n"

	val dash: String = "="
	val dashes: String = dash.repeat(60)

	println("Days To Go Calculator (Kotlin version)")
	println()
	println("$dashes")
	println()
	println("  $TextFmt")
	println("$dashes")
	println()
}


fun do_conversion( date0 : String ) {

	val dateString: String = "2018/02/21"
	val df: SimpleDateFormat = SimpleDateFormat("yyyy/MM/dd");
	// df.setTimeZone(TimeZone.getTimeZone("UTC"))
	val date: Date = df.parse(dateString)
	val time: Long = date.getTime()

	println(time)
	println(Date(time))
	println(date)
}

fun do_conversion2( date0 : String ) {

	val dateString: String = "2020/02/21"
	val df: SimpleDateFormat = SimpleDateFormat("yyyy/MM/dd");
	// df.setTimeZone(TimeZone.getTimeZone("UTC"))
	val date: Date = df.parse(dateString)
	val time: Long = date.getTime()

	println(time)
	println(Date(time))
	println(date)
}


fun main() {
	display_banner()

	val dateString: String = "2018/02/21"
	do_conversion(dateString)

	val dateString2: String = "2018/02/21"
	do_conversion2(dateString2)

	println()
	println("Finished!")
}

/* End of File */
