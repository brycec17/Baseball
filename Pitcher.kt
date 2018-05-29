/**
 * Pitcher class for representing pitcher probabilities.
 *
 * @author Bryce Colson
 * @version 2018.05.29
 *
 * @param name  name of pitcher
 * @param s     single%
 * @param d     double%
 * @param t     triple%
 * @param hr    home run%
 * @param bb    walk%
 * @param k     strikeout%
 */
data class Pitcher(val name:String, val s:Double, val d:Double, val t:Double, val hr:Double, val bb:Double,
                   val k:Double)