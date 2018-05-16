import java.util.*
import kotlin.collections.ArrayList

class TreeNode(var `val`: Int){
    var left: TreeNode? = null
    var right: TreeNode? = null
}

interface Command{
    fun execute(node: TreeNode)
}

//return null when failed to create a tree
fun createTree(str:String, seperator: String):TreeNode?{
    if(str.isEmpty()){
        return null
    }
    else{
        val strList = str.split(seperator)
        return if (strList.isEmpty()){
            null
        }else{
            val root:TreeNode = TreeNode(strList[0].toInt())
            val queue:Queue<TreeNode?> = LinkedList()
            val len = strList.size
            var peek: TreeNode?
            var value: Int?
            var index = 1
            queue.add(root)
            while (queue.isNotEmpty()){
                peek = queue.poll()
                if (peek == null) {
                    index += 2
                    continue
                }
                else{
                    if(index < len){
                        value = strList[index++].toIntOrNull()
                        if (value != null) {
                            peek.left = TreeNode(value)
                            queue.add(peek.left)
                        }
                        else{
                            queue.add(null)
                        }
                    }
                    if(index < len){
                        value = strList[index++].toIntOrNull()
                        if(value != null){
                            peek.right = TreeNode(value)
                            queue.add(peek.right)
                        }
                        else{
                            queue.add(null)
                        }
                    }
                }
            }

            root
        }
    }


}

//brand first serach
fun bfs(root:TreeNode, command: Command){
    val queue: Queue<TreeNode> = LinkedList()
    var peek: TreeNode
    queue.add(root)
    while (!queue.isEmpty()){
        peek = queue.poll()
        command.execute(peek)
        if(peek.left != null){
            queue.add(peek.left)
        }
        if(peek.right != null){
            queue.add(peek.right)
        }
    }
}

//preoder search
fun blr(root: TreeNode, command: Command){
    val stack = Stack<TreeNode>()
    var peek: TreeNode
    stack.add(root)

    while (stack.isNotEmpty()){
        peek = stack.pop()
        command.execute(peek)
        if(peek.right != null){
            stack.push(peek.right)
        }
        if(peek.left != null){
            stack.push(peek.left)
        }
    }
}
