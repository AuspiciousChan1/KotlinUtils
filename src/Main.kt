fun main(args: Array<String>){
    val root: TreeNode?
    val str = "0,1,2,3,4,5,6,7,8,9,10,11,12,.,14"
    root = createTree(str, ",")
    blr(root!!, object : Command{
        override fun execute(node: TreeNode) {
            print("${node.`val`} ")
        }
    })
}