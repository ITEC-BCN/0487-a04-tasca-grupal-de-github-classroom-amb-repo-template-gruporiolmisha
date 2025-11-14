import kotlin.random.Random

fun main(){
    val DAUS: String = "⚀ ⚁ ⚂ ⚃ ⚄ ⚅"
    val CARES_DAU: Array<String> = arrayOf("⚀", "⚁", "⚂", "⚃", "⚄", "⚅")

    var partides: Int?
    var tiradesPerPartida: Int?

    println(DAUS)
    println("Benvingut/da al joc dels daus.\nPer guanyar cada partida, la suma dels punts de les teves tirades dels teus daus ha de ser superior a la de la CPU")
    println(DAUS)

    do {
        println("Quantes partides vols jugar? (de 1 a 3)")
        partides = readLine()?.toIntOrNull()

        if (partides != null && (partides < 1 || partides > 3)){
            partides = null
            println("ERROR: Valor no acceptat!")
        }
    }while(partides == null)

    do {
        println("Quantes tirades vols fer per cada partida? (de 1 a 6)")
        tiradesPerPartida = readLine()?.toIntOrNull()

        if (tiradesPerPartida != null && (tiradesPerPartida < 1 || tiradesPerPartida > 6)){
            tiradesPerPartida = null
            println("ERROR: Valor no acceptat!")
        }
    }while(tiradesPerPartida == null)

    var tiradesGuardades: Array<IntArray>

    tiradesGuardades = Array(partides){IntArray((tiradesPerPartida + 1)) }

    for(partida in 0 until partides) {
        var acumuladorCPU: Int = 0
        var tiradaActual: Int = 0

        for (tirada in 0 until tiradesGuardades[partida].size - 1) {
            println("Tira el dau! (Intent $tirada)")
            tiradaActual = Random.nextInt(1, 6 + 1)
            println("Has tret un ${CARES_DAU[tiradaActual-1]} !")

            tiradesGuardades[partida][tirada] = tiradaActual

            tiradesGuardades[partida][tiradesPerPartida] += tiradaActual

            acumuladorCPU += Random.nextInt(1, 6 + 1)
        }

        println("Partida acabada!")
        println("Tu has aconseguit ${tiradesGuardades[partida][tiradesPerPartida]} punts")
        println("La CPU ha aconseguit $acumuladorCPU punts")

        if (tiradesGuardades[partida][tiradesPerPartida] > acumuladorCPU){
            println("Has guanyat!")
        }else if (tiradesGuardades[partida][tiradesPerPartida] < acumuladorCPU){
            println("Has perdut!")
        }else{
            println("Heu empatat!")
        }
    }
}
