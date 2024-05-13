cp -r ./allure-report/history ./allure-results/history
rm -rf ./allure-report/

allure generate
allure serve