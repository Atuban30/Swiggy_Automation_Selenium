# Swiggy_Automation_Selenium
## Overview  
This project automates the Swiggy ordering process using Selenium WebDriver in Java. It handles:  
- Logging into Swiggy using a mobile number.  
- Waiting for manual OTP entry.  
- Searching and adding a food item to the cart.  
- Navigating to the checkout page automatically.
## Prerequisites  
Ensure you have the following installed:  
- Java (JDK 8 or later)  
- Selenium WebDriver  
- ChromeDriver (compatible with your Chrome version)  
## Setup Instructions 
git clone https://github.com/Atuban30/Swiggy_Automation_Selenium.git
cd Swiggy_Automation_Selenium
## How It Works
The script opens Swiggy and logs in using the provided mobile number.
It waits for the user to manually enter the OTP.
After login, it searches for a food item and adds it to the cart.
After checking out, it add's the Address and goes for Payment Method.
## Notes
Ensure you have a stable internet connection.
The script uses Thread.sleep(30000) to wait for OTP entry. Adjust it as needed.
The automation might break if Swiggy updates its UI. Update the XPaths accordingly.
## Author
**Atuban30** ([@Atuban30](https://github.com/Atuban30))
