//
//
//

/* # Filename: testing2.kt */

// ******************************************************************
// ***
// ***   Author: David Billsbrough 
// ***  Created: Sunday, August 18, 2024 at 18:22:44 PM (EDT)
// ***  Version: $Revision:$
// ***
// ******************************************************************  

// $Id:$

import kotlin.math.abs


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

	output_display("No current event at this time")

	println()
	println("End of Report")
}

/* End of file */
