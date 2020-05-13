package com.zwartezwaan.quanumobjcatalog

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.indiv_obj.view.*

class MainActivity : AppCompatActivity() {
    var adapp:ShapeAdapter ?=null
    var shapeList =ArrayList<Shape>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load shapes
        shapeList.add(Shape("Great Dodecahedron", "The great dodecahedron is the Kepler-Poinsot solid whose dual is the small stellated dodecahedron. It is also uniform polyhedron U_(35) and Wenninger model W_(20). Its Schläfli symbol is {5,5/2}, and its Wythoff symbol is 5/2|25. It is concave, and consists of 12 intersecting pentagonal faces (12{5}).", R.drawable.great_dodecahedron))
        shapeList.add(Shape("Great Icosahedron", "One of the Kepler-Poinsot solids whose dual is the great stellated dodecahedron. It is also uniform polyhedron U_(53), Wenninger model W_(22), and has Schläfli symbol {3,5/2} and Wythoff symbol 35/2|5/3. The great icosahedron can be constructed from an icosahedron with unit edge lengths by taking the 20 sets of vertices that are mutually spaced by a distance phi, the golden ratio. The solid therefore consists of 20 equilateral triangles. The symmetry of their arrangement is such that the resulting solid contains 12 pentagrams.", R.drawable.great_icosahedron))
        shapeList.add(Shape("Icosidodecahedron", "In general, an icosidodecahedron is a 32-faced polyhedron.", R.drawable.icosidodecahedron))
        shapeList.add(Shape("Great Rhombicosidodecahedron", "The 62-faced Archimedean solid A_2 with faces 30{4}+20{6}+12{10}. It is also known as the rhombitruncated icosidodecahedron, and is sometimes improperly called the truncated icosidodecahedron (Ball and Coxeter 1987, p. 143), a name which is inappropriate since truncation would yield rectangular instead of square. The great rhombicosidodecahedron is also uniform polyhedron U_(28) and Wenninger model W_(16). It has Schläfli symbol t{3; 5} and Wythoff symbol 235|.", R.drawable.great_rhombicosidodecahedron))
        shapeList.add(Shape("Snub Cube", "The snub cube, also called the cubus simus (Kepler 1619, Weissbach and Martini 2002) or snub cuboctahedron, is an Archimedean solid having 38 faces (32 triangular and 6 square), 60 edges, and 24 vertices. It is a chiral solid, and hence has two enantiomorphous forms known as laevo (left-handed) and dextro (right-handed).", R.drawable.snub_cube))
        shapeList.add(Shape("Stellated Dodecahedron", "The small stellated dodecahedron is the Kepler-Poinsot solids whose dual polyhedron is the great dodecahedron. It is also uniform polyhedron U_(34), Wenninger model W_(21), and is the first stellation of the dodecahedron (Wenninger 1989). The small stellated dodecahedron has Schläfli symbol {5/2,5} and Wythoff symbol 5|25/2. It is concave, and is composed of 12 pentagrammic faces (12{5/2}).", R.drawable.stellated_dodecahedron))
        adapp= ShapeAdapter(this, shapeList)
        getViewShape.adapter = adapp
    }

    class ShapeAdapter:BaseAdapter{
        var listyy= ArrayList<Shape>()
        var contexty:Context?= null
        constructor(conttextt:Context, listttt:ArrayList<Shape>):super(){
            this.contexty = conttextt
            this.listyy = listttt }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var shapyshape= listyy[position]
            var inflateee = contexty!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var shapeVieww = inflateee.inflate(R.layout.indiv_obj, null)
            shapeVieww.indivImg.setImageResource(shapyshape.img!!)
            shapeVieww.indivImg.setOnClickListener{
                var intentyy = Intent(contexty, Descyy::class.java)
                intentyy.putExtra("imgyyy", shapyshape.img!!)
                intentyy.putExtra("namyy", shapyshape.name!!)
                intentyy.putExtra("desyy", shapyshape.desc!!)
                contexty!!.startActivity(intentyy)
            }

            shapeVieww.indivName.text = shapyshape.name!!
            return shapeVieww
        }

        override fun getItem(position: Int): Any {
            return listyy[position]
        }

        override fun getItemId(pos: Int): Long {
            return pos.toLong()
        }
        override fun getCount(): Int {
            return listyy.size
        }
    }
}
