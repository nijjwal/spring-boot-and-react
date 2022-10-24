from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
driver.get('http://localhost:8080/employee/register')

#Insert First Name
firstName = driver.find_element(By.ID, "firstName")
firstName.send_keys('Nijjwal')

#Insert Last Name
lastName = driver.find_element(By.ID, "lastName")
lastName.send_keys('Shrestha')

#Insert email address
emailId = driver.find_element(By.XPATH, '//*[@id="emailId"]')
emailId.send_keys('nijjwal.shrestha@gmail.com')

#Click on Captcha
#notRobotCheckBox = driver.find_element(By.XPATH, '//*[@id="recaptcha-anchor"]/div[1]')
#notRobotCheckBox.click()

#Click on Checkbox
#activeDutyCheckBox = driver.find_element(By.ID, "activeDuty")
#activeDutyCheckBox.click()

#Click on Add Employee Button
addEmployeeBtn = driver.find_element(By.XPATH, '/html/body/div[1]/div/div[2]/form/input')
addEmployeeBtn.click()








