class Solution {
    fun simplifyPath(path: String): String {
        val stack = mutableListOf<String>()

        for (part in path.split("/")) {
            when (part) {
                "", "." -> continue
                ".." -> {
                    if (stack.isNotEmpty()) {
                        stack.removeAt(stack.size - 1)
                    }
                }
                else -> stack.add(part)
            }
        }

        return if (stack.isEmpty()) {
            "/"
        } else {
            "/" + stack.joinToString("/")
        }
    }
}