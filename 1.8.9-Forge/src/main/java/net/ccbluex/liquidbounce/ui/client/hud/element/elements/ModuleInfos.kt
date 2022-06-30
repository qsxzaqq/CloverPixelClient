package net.ccbluex.liquidbounce.ui.client.hud.element.elements

import net.ccbluex.liquidbounce.ui.client.hud.element.Border
import net.ccbluex.liquidbounce.ui.client.hud.element.Element
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementInfo
import net.ccbluex.liquidbounce.ui.client.hud.element.Side
import net.ccbluex.liquidbounce.ui.font.Fonts
import net.ccbluex.liquidbounce.utils.render.ColorUtils
import net.ccbluex.liquidbounce.utils.render.RenderUtils
import net.ccbluex.liquidbounce.value.BoolValue
import net.ccbluex.liquidbounce.value.FontValue
import net.ccbluex.liquidbounce.value.IntegerValue
import java.awt.Color


/**
 * @author liulihaocai
 * InventoryHUD
 */
@ElementInfo(name = "ModuleInfos")
class ModuleInfos : Element(300.0,100.0,1F, Side(Side.Horizontal.RIGHT,Side.Vertical.UP)) {
    private val bgRedValue = IntegerValue("BGRed", 0, 0, 255)
    private val bgGreenValue = IntegerValue("BGGreen", 0, 0, 255)
    private val bgBlueValue = IntegerValue("BGBlue", 0, 0, 255)
    private val bgAlphaValue = IntegerValue("BGAlpha", 150, 0, 255)
    private val bdRedValue = IntegerValue("BDRed", 255, 0, 255)
    private val bdGreenValue = IntegerValue("BDGreen", 255, 0, 255)
    private val bdBlueValue = IntegerValue("BDBlue", 255, 0, 255)
    private val title = BoolValue("Title",true)
    private val bdRainbow = BoolValue("BDRainbow",false)
    private val fontValue = FontValue("Font",Fonts.font35)
    private val i = "§a§lEnabled§r"
    private val q = "§c§lDisabled§r"

    override fun drawElement(): Border {
        val borderColor=if(bdRainbow.get()){ColorUtils.rainbow()}else{Color(bdRedValue.get(),bdGreenValue.get(),bdBlueValue.get())}
        val backgroundColor=Color(bgRedValue.get(),bgGreenValue.get(),bgBlueValue.get(),bgAlphaValue.get())
        val font=fontValue.get()
        val startY=if(title.get()){-(6+font.FONT_HEIGHT)}else{0}.toFloat()

        //draw rect
        RenderUtils.drawRect(0F,startY,174F,66F,backgroundColor)
        RenderUtils.drawRect(0F,startY,1F,66F,borderColor)
        RenderUtils.drawRect(0F,startY,174F,startY+1,borderColor)
        RenderUtils.drawRect(0F,0F,174F,1F,borderColor)
        RenderUtils.drawRect(0F,65F,174F,66F,borderColor)
        RenderUtils.drawRect(173F,startY,174F,66F,borderColor)
        if(title.get()){
            //GameFontRender will shift y axis 3F when render string
            val str="ModuleInfos"
            font.drawString("ModuleInfos",(174F/2F)-(font.getStringWidth(str)*0.5F),-(font.FONT_HEIGHT).toFloat(),borderColor.rgb,false)
        }

        return Border(0F,startY,174F,66F)
    }
}
