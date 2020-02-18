 //Se crea un ArraList vacio de tipo Computadora, en el que se almacenan los objetos para mostrarlos
    val listaComputadoras:ArrayList<Computadora> = ArrayList()
    fun main(args : Array<String>) {
        //inicia y muestra el menu
        print("1.-Armar un nuevo equipo\n2.-Ver equipos armados\n3.-Salir\n\nElija una opcion:")
        val respuesta:String?= readLine()
        when(respuesta)
        {
            //opcion 1 llama al metodo nuevoPc
            "1" -> {nuevoPc()
                //al terminar reinicia el main para volver a mostrar el menu
                main(args)}
            //opcion 2 llama al metodo mostrarPcs
            "2" ->{mostrarPcs()
                //reinicia el main
                main(args)}
            //no hace nada solo sale
            "3" -> {}
            //si introduce otra cosa solo reinicia el main
            else ->  {println("Elija una opcion valida")
                main(args)}
        }

    }
    //Metodo que recorre la lista para imprimirla
    fun mostrarPcs()
    {
        //Comprobamos que no este vacia
        if (!listaComputadoras.isEmpty())
        {
            //forEachIndexed para enumerar el index de cada computadora y el parametro computadora para traer los atributos de cada objeto
            listaComputadoras.forEachIndexed { index, computadora ->
                print("\nComputadora #${index + 1} \nProcesador: ${computadora.Procesador}\nMemoria: ${computadora.Memoria}\nGrafica: ${computadora.Grafica}\n\n")
            }
        }else{
            println("Lista vacia\n")
        }
    }
    //metodo que crea objetos para agregarlos al ArrayList
    fun nuevoPc()
    {
        var procesador:String = ""
        var memoria:String = ""
        var grafica:String = ""
        //Ciclo que se repite hasta que elija los 3 componentes
        do {
            var iterador = false
            print("\n1.-Procesador\n2.-Memoria Ram\n3.-Tarjeta Grafica\n4.-Terminar\n\nElija una opcion:")
            val respuesta: String? = readLine()
            when (respuesta) {
                "1" -> {
                    print("\n1.-Intel Core i3\n2.-Intel Core i5\n3.-Intel Core i7\n\nElija un procesador:")
                    val respuesta: String? = readLine()
                    when (respuesta) {
                        "1" -> procesador = "Intel Core i3"
                        "2" -> procesador = "Intel Core i5"
                        "3" -> procesador = "Intel Core i7"
                        else -> procesador = "otro"
                    }
                }
                "2" -> {
                    print("\n1.-8 GB\n2.-16 GB\n3.-32 GB\n\nElija cantiodad de memoria:")
                    val respuesta: String? = readLine()
                    when (respuesta) {
                        "1" -> memoria = "8 GB"
                        "2" -> memoria = "16 GB"
                        "3" -> memoria = "32 GB"
                        else -> memoria = "otro"
                    }
                }
                "3" -> {
                    print("\n1.-GTX 1660 ti\n2.-RTX 2080 ti\n3.-Titan RTX\n\nElija una tarjeta grafica:")
                    val respuesta: String? = readLine()
                    when (respuesta) {
                        "1" -> grafica = "GTX 1660 ti"
                        "2" -> grafica = "RTX 2080 ti"
                        "3" -> grafica = "Titan RTX"
                        else -> grafica = "otro"
                    }
                }
                "4" ->{
                    //Si ningun atributo esta en blanco sale del while
                    if (procesador != "" && memoria != "" && grafica != "")
                    {
                        iterador = true
                    }else {
                        println("Asegurese de elegir todos los componentes\n")}
                }
            }
        }
        while (iterador == false)
        //Al salir del while se crea un objeto con los parametros recopilados
        val computadora = Computadora(procesador,memoria,grafica)
        //Se agrega el objeto al arreglo
        listaComputadoras.add(computadora)
    }
    //data class para crear los objetos que se guardaran en la lista(parametros que se requieren para crear el objeto)
    data class Computadora(val Procesador:String,val Memoria:String,val Grafica:String)
