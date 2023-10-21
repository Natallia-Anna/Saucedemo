// Создаем класс TestListener, который реализует интерфейс ITestListener
package test;

import driver.DriverSingleton;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    // Переопределяем метод onTestStart, который вызывается перед каждым тестом
    @Override
    public void onTestStart(ITestResult result) {
// Выводим имя теста, который начался
        System.out.println("Test " + result.getName() + " started");
    }

    // Переопределяем метод onTestSuccess, который вызывается после успешного выполнения теста
    @Override
    public void onTestSuccess(ITestResult result) {
// Выводим имя теста, который завершился успешно
        System.out.println("Test " + result.getName() + " passed");
    }

    // Переопределяем метод onTestFailure, который вызывается после неудачного выполнения теста
    @Override
    public void onTestFailure(ITestResult result) {
// Выводим имя теста, который завершился неудачно
        System.out.println("Test " + result.getName() + " failed");
// Сохраняем скриншот страницы в случае ошибки
        DriverSingleton.getInstance().takeScreenshot(result.getName());
    }

    // Переопределяем метод onTestSkipped, который вызывается после пропуска теста
    @Override
    public void onTestSkipped(ITestResult result) {
// Выводим имя теста, который был пропущен
        System.out.println("Test " + result.getName() + " skipped");
    }

    // Переопределяем метод onFinish, который вызывается после завершения всех тестов
    @Override
    public void onFinish(ITestContext context) {
// Закрываем браузер
        DriverSingleton.getInstance().closeDriver();
    }
}

