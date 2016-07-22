/* https://www.hackerrank.com/challenges/caesar-cipher-1 */
package com.negrisoli.algorithms.implementation

object CaesarCipher {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = sc.nextInt();
        var s = sc.next();
        var k = sc.nextInt();
        
        s.map(_.toInt).map(x => cripto(x, k)).map(x => print(x.toChar))
    }
           
    def cripto(c:Int, k:Int):Int  = {
        if (isUper(c)) (c-65 + k) % 26 + 65
        else if (isDown(c)) (c-97 + k)  % 26 + 97
        else c
    } 
               
    def isUper(c:Int) = c >= 65 && c <= 90
    def isDown(c:Int) = c >= 97 && c <= 122

}