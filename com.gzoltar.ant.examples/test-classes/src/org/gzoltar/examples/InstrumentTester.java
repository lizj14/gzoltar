/**
 * Copyright (C) 2018 GZoltar contributors.
 * 
 * This file is part of GZoltar.
 * 
 * GZoltar is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * 
 * GZoltar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with GZoltar. If
 * not, see <https://www.gnu.org/licenses/>.
 */
package org.gzoltar.examples;
import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * Example adapted from the research paper 'Adaptive Random Test Case Prioritization'.
 */
public class InstrumentTester {

  public static int myNumber = 1;

  protected int numLetters;

  private int numDigits;

  public InstrumentTester() {
    this.numLetters = 0;
    this.numDigits = 0;
  }

  public void linear() {
    int j = 2;
  }

  public void valueIn(int i) {
    int j = i+1;
  }

  public void thisStructure(){
    int j = this.numLetters;
  }

  public int returnValue(){
    return 0;
  }

  public void returnNone(){
    return;
  }

  public void conditionallyReturn(int i){
    if( i > 0){
      return;
    }
  }

  public void forStmt(){
    int j=0;
    for(int i=0; i!=3; i++){
      j += i;
    } 
  }

  public void forBreak(int j){
    for(int i=0; i!=3; i++){
      j += i;
      if( j > 5)
	break;
    }
  }

  public void forStmt2(){
    int j=0;
    ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(1,2,3));
    for(int i : array){
      j+=i;
    }
  }

  public void methodCall(){
    this.returnNone();
  }

  public void methodCallCondition(){
    this.conditionallyReturn(32);
  }

  public void printMethod(){
    System.out.println("hello world!");
  }

  public void ifStmt(int i){
    int j = 0;
    if(i > 3){
      j = 2;
    }
  }

  public void ifStmt2(int i){
    int j = 0;
    if(i > 3){
      j = 2;
    }else {
      j = 3;
    }
  }

  public void ifStmt3(int i){
    int j = 0;
    if(i > 3){
      j = 2;
    }
    else{
      j = 3;
    }
  }

  public void ifStmt4(int i){
    int j = 0;
    if(i > 3){
      j = 2;
    }else if( i > 2){
      j = 3;
    }else{
      j = 4;
    }
  }

  public void twoStmt(int j){
    int i =0;
    i = 3; i=4;
    if(j > 3) i = 3;
    if(j >4 ) {i=5;} i =6;
  }

  public int NumLetter(){
    return this.numLetters;
  }

  public void testSwitch(int i){
    switch(i){
	    case 1:
		    break;
            case 2: break;
            case 3:
		    System.out.println("2");
		    break;
            default:
		    System.out.println("3");
    }
  }

  public void testTry(int i){
	  try{
		  int j = 3/i;
	  }catch ( ArithmeticException  ae ){
		  System.err.println("how can here be ae error?");
	  }
	  catch ( Exception e) {
		  System.err.println("error" + e);
		  int x = 1;
	  }
	  finally{
		  System.err.println("can never get here.");
	  }
  }
}
