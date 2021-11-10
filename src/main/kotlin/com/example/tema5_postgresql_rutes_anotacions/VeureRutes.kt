package com.example.tema5_postgresql_rutes_anotacions

import classes.Ruta
import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(args: Array<String>) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sessio = Configuration().configure().buildSessionFactory().openSession()
    val q = sessio.createQuery ("from Ruta")

    for (r in q.list()) {
        r as Ruta
        println(r.nomR + " --- "+ r.punts.size + " punts:")
        for (p in r.punts)
            println("\t" + p.nomP)
    }

    sessio.close()
}
