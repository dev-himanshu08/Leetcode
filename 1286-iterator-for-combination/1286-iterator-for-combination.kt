class CombinationIterator(
    private val characters: String,
    private val combinationLength: Int
) {

    private val combinations = mutableListOf<String>()
    private var index = 0

    init {
        generate(0, StringBuilder())
    }

    private fun generate(start: Int, current: StringBuilder) {
        if (current.length == combinationLength) {
            combinations.add(current.toString())
            return
        }

        for (i in start until characters.length) {
            current.append(characters[i])

            generate(i + 1, current)

            current.deleteCharAt(current.length - 1)
        }
    }

    fun next(): String {
        return combinations[index++]
    }

    fun hasNext(): Boolean {
        return index < combinations.size
    }
}