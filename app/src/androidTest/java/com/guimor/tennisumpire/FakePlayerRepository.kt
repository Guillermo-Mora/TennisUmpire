package com.guimor.tennisumpire

import com.guimor.tennisumpire.domain.operation_result.result_type.ResultType
import com.guimor.tennisumpire.domain.operation_result.result_type.DatabaseSuccess
import com.guimor.tennisumpire.domain.model.player.PlayerBackhand
import com.guimor.tennisumpire.domain.model.player.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.player.PlayerGender
import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.room_database.player.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.time.LocalDate

class FakePlayerRepository : PlayerRepository {
    override fun getAllPlayers(): Flow<List<Player>> {
        return flowOf(
            listOf(
                Player(
                    uid = 0,
                    firstName = "Guillermo",
                    lastName = "Mora",
                    birthdate = LocalDate.of(2005, 10, 27),
                    height = 183f,
                    weight = 68f,
                    country = null,
                    gender = PlayerGender.MALE,
                    dominantHand = PlayerDominantHand.LEFT,
                    backhand = PlayerBackhand.ONE_HANDED,
                    photo = null
                ),
                Player(
                    uid = 1,
                    firstName = "María",
                    lastName = "Garcíaaskdjlkasjfkldsjfkldjfklsdjfkldsjfklsjfklsjfdklsjfdlksjflksjdflksjsdlfkjdslkfjslkfjlkfsejklfjflkdsjflkdjfdslkjsfdlkjfklsjflksdjflksjdlksjfdlksjdlkjfdlkfsj",
                    birthdate = LocalDate.of(2003, 5, 14),
                    height = 175f,
                    weight = 62f,
                    country = null,
                    gender = PlayerGender.FEMALE,
                    dominantHand = PlayerDominantHand.RIGHT,
                    backhand = PlayerBackhand.TWO_HANDED,
                    photo = null
                ),
                Player(
                    uid = 2,
                    firstName = "Carlos",
                    lastName = "Rodríguez",
                    birthdate = LocalDate.of(2004, 8, 22),
                    height = 188f,
                    weight = 75f,
                    country = null,
                    gender = PlayerGender.MALE,
                    dominantHand = PlayerDominantHand.RIGHT,
                    backhand = PlayerBackhand.TWO_HANDED,
                    photo = null
                ),
                Player(
                    uid = 3,
                    firstName = "Sofia",
                    lastName = "Müller",
                    birthdate = LocalDate.of(2006, 3, 9),
                    height = 172f,
                    weight = 59f,
                    country = null,
                    gender = PlayerGender.FEMALE,
                    dominantHand = PlayerDominantHand.LEFT,
                    backhand = PlayerBackhand.ONE_HANDED,
                    photo = null
                ),
                Player(
                    uid = 4,
                    firstName = "Lucas",
                    lastName = "Silva",
                    birthdate = LocalDate.of(2005, 12, 1),
                    height = 182f,
                    weight = 72f,
                    country = null,
                    gender = PlayerGender.MALE,
                    dominantHand = PlayerDominantHand.RIGHT,
                    backhand = PlayerBackhand.TWO_HANDED,
                    photo = null
                ),
                Player(
                    uid = 5,
                    firstName = "Emma",
                    lastName = "Dubois",
                    birthdate = LocalDate.of(2004, 7, 18),
                    height = 178f,
                    weight = 65f,
                    country = null,
                    gender = PlayerGender.FEMALE,
                    dominantHand = PlayerDominantHand.RIGHT,
                    backhand = PlayerBackhand.TWO_HANDED,
                    photo = null
                ),
                Player(
                    uid = 6,
                    firstName = "Alessandro",
                    lastName = "Rossi",
                    birthdate = LocalDate.of(2003, 11, 5),
                    height = 185f,
                    weight = 70f,
                    country = null,
                    gender = PlayerGender.MALE,
                    dominantHand = PlayerDominantHand.LEFT,
                    backhand = PlayerBackhand.TWO_HANDED,
                    photo = null
                ),
                Player(
                    uid = 7,
                    firstName = "Olivia",
                    lastName = "Anderson",
                    birthdate = LocalDate.of(2005, 2, 28),
                    height = 173f,
                    weight = 61f,
                    country = null,
                    gender = PlayerGender.FEMALE,
                    dominantHand = PlayerDominantHand.RIGHT,
                    backhand = PlayerBackhand.ONE_HANDED,
                    photo = null
                ),
                Player(
                    uid = 8,
                    firstName = "Pablo",
                    lastName = "Fernández",
                    birthdate = LocalDate.of(2004, 6, 12),
                    height = 190f,
                    weight = 78f,
                    country = null,
                    gender = PlayerGender.MALE,
                    dominantHand = PlayerDominantHand.RIGHT,
                    backhand = PlayerBackhand.TWO_HANDED,
                    photo = null
                ),
                Player(
                    uid = 9,
                    firstName = "Yuki",
                    lastName = "Tanaka",
                    birthdate = LocalDate.of(2006, 4, 20),
                    height = 168f,
                    weight = 55f,
                    country = null,
                    gender = PlayerGender.FEMALE,
                    dominantHand = PlayerDominantHand.LEFT,
                    backhand = PlayerBackhand.ONE_HANDED,
                    photo = null
                ),
                Player(
                    uid = 10,
                    firstName = "Juan",
                    lastName = "López",
                    birthdate = LocalDate.of(2003, 9, 8),
                    height = 186f,
                    weight = 76f,
                    country = null,
                    gender = PlayerGender.MALE,
                    dominantHand = PlayerDominantHand.RIGHT,
                    backhand = PlayerBackhand.TWO_HANDED,
                    photo = null
                ),
                Player(
                    uid = 11,
                    firstName = "Charlotte",
                    lastName = "Petrov",
                    birthdate = LocalDate.of(2005, 1, 16),
                    height = 176f,
                    weight = 64f,
                    country = null,
                    gender = PlayerGender.FEMALE,
                    dominantHand = PlayerDominantHand.RIGHT,
                    backhand = PlayerBackhand.TWO_HANDED,
                    photo = null
                ),
                Player(
                    uid = 12,
                    firstName = "Mateo",
                    lastName = "González",
                    birthdate = LocalDate.of(2004, 10, 3),
                    height = 181f,
                    weight = 71f,
                    country = null,
                    gender = PlayerGender.MALE,
                    dominantHand = PlayerDominantHand.LEFT,
                    backhand = PlayerBackhand.ONE_HANDED,
                    photo = null
                ),
                Player(
                    uid = 13,
                    firstName = "Isabella",
                    lastName = "Bianchi",
                    birthdate = LocalDate.of(2006, 5, 25),
                    height = 170f,
                    weight = 58f,
                    country = null,
                    gender = PlayerGender.FEMALE,
                    dominantHand = PlayerDominantHand.LEFT,
                    backhand = PlayerBackhand.TWO_HANDED,
                    photo = null
                ),
                Player(
                    uid = 14,
                    firstName = "David",
                    lastName = "Wilson",
                    birthdate = LocalDate.of(2003, 8, 11),
                    height = 189f,
                    weight = 77f,
                    country = null,
                    gender = PlayerGender.MALE,
                    dominantHand = PlayerDominantHand.RIGHT,
                    backhand = PlayerBackhand.TWO_HANDED,
                    photo = null
                ),
                Player(
                    uid = 15,
                    firstName = "Sophie",
                    lastName = "Schmidt",
                    birthdate = LocalDate.of(2005, 7, 19),
                    height = 174f,
                    weight = 63f,
                    country = null,
                    gender = PlayerGender.FEMALE,
                    dominantHand = PlayerDominantHand.RIGHT,
                    backhand = PlayerBackhand.ONE_HANDED,
                    photo = null
                ),
                Player(
                    uid = 16,
                    firstName = "Rafael",
                    lastName = "Santos",
                    birthdate = LocalDate.of(2004, 3, 6),
                    height = 184f,
                    weight = 73f,
                    country = null,
                    gender = PlayerGender.MALE,
                    dominantHand = PlayerDominantHand.RIGHT,
                    backhand = PlayerBackhand.TWO_HANDED,
                    photo = null
                ),
                Player(
                    uid = 17,
                    firstName = "Léa",
                    lastName = "Martin",
                    birthdate = LocalDate.of(2006, 2, 13),
                    height = 177f,
                    weight = 66f,
                    country = null,
                    gender = PlayerGender.FEMALE,
                    dominantHand = PlayerDominantHand.LEFT,
                    backhand = PlayerBackhand.TWO_HANDED,
                    photo = null
                ),
                Player(
                    uid = 18,
                    firstName = "Andrés",
                    lastName = "Martínez",
                    birthdate = LocalDate.of(2003, 12, 30),
                    height = 187f,
                    weight = 74f,
                    country = null,
                    gender = PlayerGender.MALE,
                    dominantHand = PlayerDominantHand.LEFT,
                    backhand = PlayerBackhand.ONE_HANDED,
                    photo = null
                ),
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
        )
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