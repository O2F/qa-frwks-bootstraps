Feature: Example Test Plan

	#@PRECOND_XTP-383
	Background: 
		Given the user is in the login page

	#This is only a example test
	@TEST_XTP-382 @TESTSET_XTP-384
	Scenario: Test Example
		When the user inserts valid credentions 
		#Then the user see the product page
		#And a table with the available products
	@TEST_XTP-385 @TESTSET_XTP-384
	Scenario Outline: Negative Test example
		#When the user tries to login using the user "<user>" and password "<password>"
		#Then he receives the message "<msg>"
		
		Examples:
		|user|password|msg|
		|locked_out_user|secret_sauce|Epic sadface: Sorry, this user has been locked out.|
		|standard_usera|secret_sauce|Epic sadface: Username and password do not match any user in this service|
