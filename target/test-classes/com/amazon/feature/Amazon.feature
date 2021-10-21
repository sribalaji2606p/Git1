Feature: To check Amazon Order Tracking and Cancellation funtionality

Scenario: User Login
    Given Launch the application sign-in page
    When Enter UserName
    And Click continue button
    And Enter Password
    And Click sign-in button
    Then User to be navigated to Homepage
    
Scenario: Order Summary Page
    Given Refresh the homepage
    When Click Returns and Orders icon
    Then User to be naviagted to Your Orders page
    
 Scenario: Search Order Functionality
     Given Your order page to be opened
     When Extract the order number and paste it in search bar
     And Click serach button
     Then Order details have to be displayed
    
Scenario: Tracking Functionality
    When Click Track Package button
    Then Road map along with ETA and shipping address to be displayed
    
Scenario: Order Cancellation
    Given Your order page to be opened
    When Click Cancel Item button
    And Select the items to be cancelled
    And Select the cancellation reason
    And Click Request Cancellation
    Then User to be navigated to your order page
	