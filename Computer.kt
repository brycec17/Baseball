import java.util.Random

/**
 * Computer class for computing matchup probabilities.
 *
 * @author Bryce Colson
 * @version 2018.05.29
 *
 * @param b batter
 * @param p pitcher
 * @constructor sets the batter to the b and the pitcher to p
 */
class Computer(b:Batter, p:Pitcher) {
    private val batter:Batter
    private val pitcher:Pitcher
    companion object {
        private val s_avg = 0.1386
        private val d_avg = 0.0455
        private val t_avg = 0.0043
        private val hr_avg = 0.0296
        private val bb_avg = 0.0832
        private val k_avg = 0.2255
    }

    init {
        batter = b;
        pitcher = p;
    }

    /**
     * Returns the batter.
     *
     * @return batter
     */
    fun batter():Batter {
        return batter;
    }

    /**
     * Returns the pitcher.
     *
     * @return pitcher
     */
    fun pitcher():Pitcher {
        return pitcher;
    }

    /**
     * Computes the resulting probability of a matchup between batter and pitcher
     *
     * @param x batter probability
     * @param y pitcher probability
     * @param z league average
     * @return resulting matchup probability
     */
    private fun compute(x:Double, y:Double, z:Double):Double {
        val a = (x * y) / z
        val b = ((1 - x) * (1 - y)) / (1 - z)
        return a / (a + b)
    }

    /**
     * Returns the probability of a single.
     *
     * @return probability of a single
     */
    fun s():Double {
        return compute(batter.s, pitcher.s, s_avg)
    }

    /**
     * Returns the probability of a double.
     *
     * @return probability of a double
     */
    fun d():Double {
        return compute(batter.d, pitcher.d, d_avg)
    }

    /**
     * Returns the probability of a triple.
     *
     * @return probability of a triple
     */
    fun t():Double {
        return compute(batter.t, pitcher.t, t_avg)
    }

    /**
     * Returns the probability of a home run.
     *
     * @return probability of a home run
     */
    fun hr():Double {
        return compute(batter.hr, pitcher.hr, hr_avg)
    }

    /**
     * Returns the probability of a walk.
     *
     * @return probability of a walk
     */
    fun bb():Double {
        return compute(batter.bb, pitcher.bb, bb_avg)
    }

    /**
     * Returns the probability of a strikeout.
     *
     * @return probability of a strikeout
     */
    fun k():Double {
        return compute(batter.k, pitcher.k, k_avg)
    }

    /**
     * Returns a random plate appearance result based off of the projected
     * matchup probabilities.
     *
     * @return plate appearance result
     */
    fun pa():PlateEnum {
        val s = s()*1000
        val d = d()*1000 + s
        val t = t()*1000 + d
        val hr = hr()*1000 + t
        val bb = bb()*1000 + hr
        val k = k()*1000 + bb

        val rand = Random()
        val n = rand.nextInt(1000)
        if (n < s) {
            return PlateEnum.S
        }
        else if (n < d) {
            return PlateEnum.D
        }
        else if (n < t) {
            return PlateEnum.T
        }
        else if (n < hr) {
            return PlateEnum.HR
        }
        else if (n < bb) {
            return PlateEnum.BB
        }
        else if (n < k) {
            return PlateEnum.K
        }
        else {
            return PlateEnum.OUT
        }
    }
}