# CS 445 Final Project
### Description
---
#### Imagine:
After a pretty long drive I arrived at one of this country's great parks. Beautiful weather, great views, couldn't wait to stretch a bit and then enjoy the view. Except that the park admission fee was to be paid by cash only, honor system: you put the money in an envelope, write the license place number of your vehicle on the envelope, and then drop the envelope in a collection box.

If you don't have the cash, tough luck, the park administrators don't seem to care too much. And if you don't have the right amount, then consider yourself lucky, you just made a "donation" to the Park system.

Why couldn't we pay the admission fee using our phones? It's anybody's guess, however the purpose of this project is to create the back-end software that would allow such payment. Read below for the high-level requirements.

#### I Should Be Able To:

__As a tourist__ I should be able to get a list of all parks in the state, select one of them and view the admission fees for that park.

I could then pay for admission by specifying the type of vehicle I'm paying for, e.g. two-axle, motorcycle, etc. and providing the additional information required, such as license place state, license plate number, credit card information (i.e. name on card, card number, security code, billing address/state/zip). An email address will be required for sending a payment confirmation.

Of course I expect to receive an order number after payment has been processed. I could use the order number to submit a comment about the park I visited. Normally, in this day and age, I should be able to see comments posted by other visitors for each park.

__As a park ranger__ I should be able to check if payment has been made for a vehicle based on that plate's state and number.

__As an employee of the state government__ I need to maintain the list of parks and the admission fees for each of them; such fees change from time to time. Also, my boss makes me generate reports about the parks. She wants to know admission numbers by parks for various time frames, e.g. last month, between 12/15 and 12/31, etc. She also wants to know the revenue collected for all parks in a given time period, as a total and broken down by park.

Lastly, I expect that our Customer Service team will receive calls for assistance from time to time and they should be able to search for past orders, based on the last four digits of a CC number and possibly a date range, or by a license plate number and possibly a date range.

---
##### My drafts:

1. Park Model
	- BasePark - this is a class
		- ParkContract
		- StatePark
		- NationalPark
	- Info // maybe this can be a class too, but I will need to check
		- StaticInfo	// Initial Idea, DynamicInfo and Static Info is treated as 2 different things.
			- Address
			- Region
			- Name
			- Date
			- Status
			- PID
			- Other Info that usually will not be changed
			- __StaticInfoContract__
		- DynamicInfo
			- Order
			- Note
			- Other Info that can be updated constantly or changed constantly
			- __DynamicInfoContract__