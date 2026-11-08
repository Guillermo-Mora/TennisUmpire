package com.guimor.tennisumpire.room_database.player

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.guimor.tennisumpire.domain.model.Country
import com.guimor.tennisumpire.domain.model.player.PlayerBackhand
import com.guimor.tennisumpire.domain.model.player.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.player.PlayerGender
import com.guimor.tennisumpire.domain.operation_result.result_type.DatabaseSuccess
import com.guimor.tennisumpire.domain.operation_result.result_type.ResultType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.time.LocalDate

class FakePlayerRepository : PlayerRepository {
    override fun getAllPlayers(): PagingSource<Int, Player> {
        return object : PagingSource<Int, Player>() {
            override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Player> {
                return LoadResult.Page(
                    data = listOf(
                        Player(
                            uid = 1,
                            firstName = "Nina",
                            lastName = "Larsson",
                            birthdate = LocalDate.of(2005, 9, 7),
                            height = 179f,
                            weight = 67f,
                            country = Country.COLOMBIA,
                            gender = PlayerGender.FEMALE,
                            dominantHand = PlayerDominantHand.RIGHT,
                            backhand = PlayerBackhand.TWO_HANDED,
                            photo = null
                        ),
                        Player(
                            uid = 2,
                            firstName = "Guillermo",
                            lastName = "Mora",
                            birthdate = LocalDate.of(2005, 9, 7),
                            height = 179f,
                            weight = 67f,
                            country = Country.COOK_ISLANDS,
                            gender = PlayerGender.MALE,
                            dominantHand = PlayerDominantHand.LEFT,
                            backhand = PlayerBackhand.ONE_HANDED,
                            photo = null
                        ),
                    ),
                    prevKey = null,
                    nextKey = null
                )
            }

            override fun getRefreshKey(state: PagingState<Int, Player>): Int {
                return 1
            }
        }
    }

    override suspend fun insertPlayer(player: Player): ResultType {
        return DatabaseSuccess.REGISTRY_CREATED
    }

    override suspend fun getPlayer(playerUid: Int): Player {
        return Player(
            uid = 19,
            firstName = "Nina",
            lastName = "Larsson",
            birthdate = LocalDate.of(2005, 9, 7),
            height = 179f,
            weight = 67f,
            country = null,
            gender = PlayerGender.FEMALE,
            dominantHand = PlayerDominantHand.RIGHT,
            backhand = PlayerBackhand.TWO_HANDED,
            photo = null
        )
    }

    override fun getPlayerFlow(playerUid: Int): Flow<Player> {
        return flowOf(
            Player(
                uid = 19,
                firstName = "Nina",
                lastName = "Larsson",
                birthdate = LocalDate.of(2005, 9, 7),
                height = 179f,
                weight = 67f,
                country = null,
                gender = PlayerGender.FEMALE,
                dominantHand = PlayerDominantHand.RIGHT,
                backhand = PlayerBackhand.TWO_HANDED,
                photo = null
            )
        )
    }

    override suspend fun deletePlayer(playerUid: Int): ResultType {
        return DatabaseSuccess.REGISTRY_DELETED
    }

    override suspend fun editPlayer(player: Player): ResultType {
        return DatabaseSuccess.REGISTRY_EDITED
    }

    override suspend fun toggleAddPlayerToFavourites(playerUid: Int) {}
}