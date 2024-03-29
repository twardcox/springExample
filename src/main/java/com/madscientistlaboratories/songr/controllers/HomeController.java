package com.madscientistlaboratories.songr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
  @GetMapping("/")
  public String getRoot(){
    System.out.println("somebody got the root");
    return "helloworld";
  }

    @GetMapping("/sayhello/{name}")
  public String getSayHello(@PathVariable String name, Model m){
    m.addAttribute("firstName", name);
    return "sayhello";
  }

//  @GetMapping("/sayhello")
//  public String getSayHello(@RequestParam(required = false, defaultValue = "Friendo") String name, Model m){
//    m.addAttribute("firstName", name);
//    return "sayhello";
//  }

  @GetMapping("/capitalize/{name}")
  public String getSayHelloCap(@PathVariable(required = false) String name, Model m){
    System.out.println("THIS IS THE NAME " + name);
    m.addAttribute("firstName", name.toUpperCase());
    return "capitalizeMe";
  }

  @GetMapping("/reverse")
  public String getReverseWords(@RequestParam(required = false) String sentence, Model m){
    System.out.println("THIS IS THE NAME " + sentence);

    m.addAttribute("sentence", reverseWord(sentence));
    return "reverseword";
  }

  public static String reverseWord(String str){
    String[] words = str.split("\\s");
//    Collections.reverse(Arrays.asList(words));
    StringBuilder reverseWord = new StringBuilder();
    for(String w:words){
      reverseWord.insert(0, w).insert(0," ");
    }
    return reverseWord.toString().trim();
  }

}


