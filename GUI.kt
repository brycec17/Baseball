import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField

class GUI:ActionListener {
    private val f:JFrame
    private val bnl:JLabel
    private val bn:JTextField
    private val bsl:JLabel
    private val bs:JTextField
    private val bdl:JLabel
    private val bd:JTextField
    private val btl:JLabel
    private val bt:JTextField

    init {
        f = JFrame()

        bnl = JLabel("Batter's name")
        bnl.setBounds(50, 30, 175, 20)
        bn = JTextField()
        bn.setBounds(50, 50, 175, 20)
        bsl = JLabel("Batter's singles")
        bsl.setBounds(50, 80, 175, 20)
        bs = JTextField()
        bs.setBounds(50, 100, 175, 20)
        bdl = JLabel("Batter's doubles")
        bdl.setBounds(50, 130, 175, 20)
        bd = JTextField()
        bd.setBounds(50, 150, 175, 20)
        btl = JLabel("Batter's triples")
        btl.setBounds(50, 180, 185, 20)
        bt = JTextField()
        bt.setBounds(50, 200, 175, 20)

        f.add(bnl)
        f.add(bn)
        f.add(bsl)
        f.add(bs)
        f.add(bdl)
        f.add(bd)
        f.add(btl)
        f.add(bt)

        f.setSize(1000, 500)
        f.setLayout(null)
        f.setVisible(true)
    }

    override fun actionPerformed(e: ActionEvent) {

    }

    companion object {
        @JvmStatic
        fun main(args:Array<String>) {
            GUI()
        }
    }
}