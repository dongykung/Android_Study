package com.dkproject.compose_codelab.Chapter4.unscramble

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel: ViewModel() {

    private var usedWords: MutableSet<String> = mutableSetOf()
    private lateinit var currentWord: String

    var userGuess by mutableStateOf("")
        private set

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState = _uiState.asStateFlow()

    init {
        resetGame()
    }

    private fun pickRandomWordAndShuffle(): String {
        // Continue picking up a new random word until you get one that hasn't been used before
        currentWord = allWords.random()
        if (usedWords.contains(currentWord)) {
            return pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentWord)
            return shuffleCurrentWord(currentWord)
        }
    }

    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        // Scramble the word
        tempWord.shuffle()
        while (String(tempWord) == word) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    fun resetGame() {
        usedWords.clear()
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
    }

    fun updateUserGuess(guessedWord: String){
        userGuess = guessedWord
    }

    fun checkUserGuess() {
        if(userGuess.equals(currentWord, ignoreCase = true)) {
            val updateScore = _uiState.value.score.plus(1)
            updateGameState(updateScore)
        } else {
            _uiState.update {
                it.copy(isGuessedWordWrong = true)
            }
        }
        updateUserGuess("")
    }

    fun skipWord() {
        updateGameState(_uiState.value.score)
        // Reset user guess
        updateUserGuess("")
    }

    private fun updateGameState(updateScore: Int) {
        if (usedWords.size == 10) {
            _uiState.update {
                it.copy(
                    isGuessedWordWrong = false,
                    score = updateScore,
                    isGameOver = true
                )
            }
        } else {
            _uiState.update {
                it.copy(
                    isGuessedWordWrong = false,
                    currentScrambledWord = pickRandomWordAndShuffle(),
                    currentWordCount = it.currentWordCount.inc(),
                    score = updateScore
                )
            }
        }
    }
}

data class GameUiState(
    val currentScrambledWord: String = "",
    val isGuessedWordWrong: Boolean = false,
    val score: Int = 0,
    val currentWordCount: Int = 1,
    val isGameOver: Boolean = false
)