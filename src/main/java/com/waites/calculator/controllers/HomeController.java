package com.waites.calculator.controllers;

import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index (@RequestParam(value = "firstNum", required = false)String firstNum,
                         @RequestParam(value = "operation", required = false)String operation,
                         @RequestParam(value = "secondNum", required = false)String secondNum,
                         @RequestParam(value = "message", required = false)String message,
                         Model model){
        double result = 0;
        if (operation != null){
            switch (operation){
                case "+":
                    result = Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
                    break;
                case "-":
                    result = Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
                    break;
                case "*":
                    result = Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
                    break;
                case "/":
                    if (Double.parseDouble(secondNum) == 0){
                        throw new ArithmeticException("You cannot divide by 0");
                    } else {
                        result = Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
                        break;
                    }
                default:
                    break;
            }
        }

        model.addAttribute("calcModel", firstNum + " " + operation + " " + secondNum + " = " + result);
        return "index";
    }

//    @RequestMapping("/error")
//    public String error(){
//        return "error";
//    }
}
