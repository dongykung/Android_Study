package com.dkproject.compose_codelab.Chapter5

import com.dkproject.compose_codelab.Chapter5.RaceTracker.RaceParticipant
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test


class RaceParticipantTest {
    private val raceParticipant = RaceParticipant(name = "dongkyung")

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun raceParticipant_RaceStarted_ProgressUpdate() = runTest {
        val expectedProgress = 1
        launch { raceParticipant.run() }
        advanceTimeBy(raceParticipant.progressDelayMillis) //값만큼 시간을 진행 / 테스트 실행 시간 줄이는데 사용
        runCurrent() //advanceTimeBy는 지정된 시간에 예약된 작업을 실행하지 않으므로 runCurrent()함수 호출. 이 함수는 현재 시간에 대기 중인 작업을 실행
        assertEquals(expectedProgress, raceParticipant.currentProgress)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun raceParticipant_RaceFinished_ProgressUpdate() = runTest {
        launch { raceParticipant.run() }
        advanceTimeBy(raceParticipant.maxProgress * raceParticipant.progressDelayMillis)
        runCurrent()
        assertEquals(100, raceParticipant.currentProgress)
    }
}