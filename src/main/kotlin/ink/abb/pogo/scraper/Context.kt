/**
 * Pokemon Go Bot  Copyright (C) 2016  PokemonGoBot-authors (see authors.md for more information)
 * This program comes with ABSOLUTELY NO WARRANTY;
 * This is free software, and you are welcome to redistribute it under certain conditions.
 *
 * For more information, refer to the LICENSE file in this repositories root directory
 */

package ink.abb.pogo.scraper

import com.google.common.util.concurrent.AtomicDouble
import com.pokegoapi.api.PokemonGo
import com.pokegoapi.api.player.PlayerProfile
import ink.abb.pogo.scraper.gui.SocketServer
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

data class Context(
        val api: PokemonGo,
        val profile: PlayerProfile,
        val lat: AtomicDouble,
        val lng: AtomicDouble,

        val startXp: AtomicLong,
        val pokemonStats: Pair<AtomicInteger, AtomicInteger>,
        val itemStats: Pair<AtomicInteger, AtomicInteger>,

        val server: SocketServer,

        var walking: AtomicBoolean = AtomicBoolean(false)
)
