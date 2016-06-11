object UtopianTree {

    def main(args:Array[String]) {
        val sc = new java.util.Scanner(System.in)
        val nTests = sc.nextInt
        
        for (i <- 0 to nTests - 1) {
            val cycles = sc.nextInt
            println(cycle(cycles))
        }
    }

    def cycle(cycles:Int): Int = {
        if (cycles == 0) {
            return 1
        }
    
        if (cycles % 2 == 1) {
            return cycle(cycles - 1) * 2
        } else {
            return cycle(cycles - 1) + 1
        }
    }

}
