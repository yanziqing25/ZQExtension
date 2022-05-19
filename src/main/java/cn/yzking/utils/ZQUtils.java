package cn.yzking.utils;

import cn.nukkit.item.Item;
import cn.nukkit.plugin.Plugin;
import cn.yzking.extension.ExtensionMain;
import cn.yzking.extension.task.CheckPluginUpdateTask;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Yanziqing25
 */
public class ZQUtils {
    public static String transformMD5(String string, String salt) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update((string + salt).getBytes());
            return new BigInteger(1, md5.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getItemID(String str) {
        return Integer.parseInt(str.split(":")[0]);
    }

    public static int getItemMeta(String str) {
        if (str.contains(":")) {
            return Integer.parseInt(str.split(":")[1]);
        } else {
            return 0;
        }
    }

    public static int getItemMeta(Item item) {
        int meta = 0;
        if (item.hasMeta()) {
            try {
                Field metaField = Item.class.getDeclaredField("meta");
                metaField.setAccessible(true);
                meta = metaField.getInt(item);
                metaField.setAccessible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return meta;
    }

    public static String getItemNameInChinese(Item item) {
        int id = item.getId();
        int meta = getItemMeta(item);
        switch (id) {
            case 0:
                return "空气";
            case 1:
                if (meta == 1) return "花岗岩";
                if (meta == 2) return "磨制花岗岩";
                if (meta == 3) return "闪长岩";
                if (meta == 4) return "磨制闪长岩";
                if (meta == 5) return "安山岩";
                if (meta == 6) return "磨制安山岩";
                return "石头";
            case 2:
                return "草方块";
            case 3:
                if (meta == 1) return "砂土";
                if (meta == 2) return "灰化土";
                return "泥土";
            case 4:
                return "圆石";
            case 5:
                if (meta == 1) return "云杉木板";
                if (meta == 2) return "白桦木板";
                if (meta == 3) return "丛林木板";
                if (meta == 4) return "金合欢木板";
                if (meta == 5) return "深色橡木木板";
                return "橡木木板";
            case 6:
                if (meta == 1) return "云杉树苗";
                if (meta == 2) return "白桦树苗";
                if (meta == 3) return "丛林树苗";
                if (meta == 4) return "金合欢树苗";
                if (meta == 5) return "深色橡树树苗";
                return "橡树树苗";
            case 7:
                return "基岩";
            case 8:
                return "水";
            case 9:
                return "水";
            case 10:
                return "岩浆";
            case 11:
                return "岩浆";
            case 12:
                if (meta == 1) return "红沙";
                return "沙子";
            case 13:
                return "砂砾";
            case 14:
                return "金矿石";
            case 15:
                return "铁矿石";
            case 16:
                return "煤矿石";
            case 17:
                if (meta == 1) return "云杉木";
                if (meta == 2) return "白桦木";
                if (meta == 3) return "丛林木";
                return "橡木";
            case 18:
                if (meta == 1) return "云杉树叶";
                if (meta == 2) return "白桦树叶";
                if (meta == 3) return "丛林树叶";
                return "橡树树叶";
            case 19:
                return "海绵";
            case 20:
                return "玻璃";
            case 21:
                return "青金石矿石";
            case 22:
                return "青金石块";
            case 23:
                return "发射器";
            case 24:
                if (meta == 1) return "錾制砂岩";
                if (meta == 2) return "平滑砂岩";
                return "砂岩";
            case 25:
                return "音符盒";
            case 26:
                return "床";
            case 27:
                return "充能铁轨";
            case 28:
                return "探测铁轨";
            case 29:
                return "粘性活塞";
            case 30:
                return "蜘蛛网";
            case 31:
                if (meta == 1) return "草";
                if (meta == 2) return "蕨";
                return "枯萎的灌木";
            case 32:
                return "枯萎的灌木";
            case 33:
                return "活塞";
            case 34:
                return "活塞头";
            case 35:
                if (meta == 1) return "橙色羊毛";
                if (meta == 2) return "洋红色羊毛";
                if (meta == 3) return "浅蓝色羊毛";
                if (meta == 4) return "黄色羊毛";
                if (meta == 5) return "石灰色羊毛";
                if (meta == 6) return "粉红色羊毛";
                if (meta == 7) return "灰色羊毛";
                if (meta == 8) return "浅灰色羊毛";
                if (meta == 9) return "青色羊毛";
                if (meta == 10) return "紫色羊毛";
                if (meta == 11) return "蓝色羊毛";
                if (meta == 12) return "棕色羊毛";
                if (meta == 13) return "绿羊色毛";
                if (meta == 14) return "红羊色毛";
                if (meta == 15) return "黑羊色毛";
                return "白羊毛";
            case 37:
                return "蒲公英";
            case 38:
                if (meta == 1) return "兰花";
                if (meta == 2) return "绒球葱";
                if (meta == 3) return "茜草花";
                if (meta == 4) return "红色郁金香";
                if (meta == 5) return "橙色郁金香";
                if (meta == 6) return "白色郁金香";
                if (meta == 7) return "粉红色郁金香";
                if (meta == 8) return "滨菊";
                return "虞美人";
            case 39:
                return "棕色蘑菇";
            case 40:
                return "红色蘑菇";
            case 41:
                return "金块";
            case 42:
                return "铁块";
            case 43://TODO:不标准
                return "双层石板";
            case 44:
                if (meta == 1) return "砂岩台阶";
                if (meta == 2) return "木质台阶";
                if (meta == 3) return "圆石台阶";
                if (meta == 4) return "砖台阶";
                if (meta == 5) return "石砖台阶";
                if (meta == 6) return "地狱砖台阶";
                if (meta == 7) return "石英台阶";
                return "石台阶";
            case 45:
                return "砖块";
            case 46:
                return "TNT";
            case 47:
                return "书架";
            case 48:
                return "苔石";
            case 49:
                return "黑曜石";
            case 50:
                return "火把";
            case 51:
                return "火";
            case 52:
                return "刷怪箱";
            case 53:
                return "橡木楼梯";
            case 54:
                return "箱子";
            case 55:
                return "红石线";
            case 56:
                return "钻石矿石";
            case 57:
                return "钻石块";
            case 58:
                return "工作台";
            case 59:
                return "小麦";
            case 60:
                return "耕地";
            case 61:
                return "熔炉";
            case 62:
                return "熔炉";
            case 63:
                return "橡木告示牌";
            case 64:
                return "橡木门";
            case 65:
                return "梯子";
            case 66:
                return "铁轨";
            case 67:
                return "圆石楼梯";
            case 68:
                return "墙上的橡木告示牌";
            case 69:
                return "拉杆";
            case 70:
                return "石质压力板";
            case 71:
                return "铁门";
            case 72:
                return "木质压力板";
            case 73:
                return "红石矿石";
            case 74:
                return "红石矿石";
            case 75:
                return "红石火把";
            case 76:
                return "红石火把";
            case 77:
                return "石质按钮";
            case 78:
                return "雪";
            case 79:
                return "冰";
            case 80:
                return "雪";
            case 81:
                return "仙人掌";
            case 82:
                return "粘土";
            case 83:
                return "甘蔗";
            case 84:
                return "唱片机";
            case 85:
                return "橡木栅栏";
            case 86:
                return "南瓜";
            case 87:
                return "地狱岩";
            case 88:
                return "灵魂沙";
            case 89:
                return "萤石";
            case 90:
                return "下界传送门方块";
            case 91:
                return "南瓜灯";
            case 92:
                return "蛋糕";
            case 93:
                return "红石中继器";
            case 94:
                return "红石中继器";
            case 95:
                if (meta == 1) return "橙色玻璃";
                if (meta == 2) return "洋红色玻璃";
                if (meta == 3) return "浅蓝色玻璃";
                if (meta == 4) return "黄色玻璃";
                if (meta == 5) return "石灰色玻璃";
                if (meta == 6) return "粉红色玻璃";
                if (meta == 7) return "灰色玻璃";
                if (meta == 8) return "浅灰色玻璃";
                if (meta == 9) return "青色玻璃";
                if (meta == 10) return "紫色玻璃";
                if (meta == 11) return "蓝色玻璃";
                if (meta == 12) return "棕色玻璃";
                if (meta == 13) return "绿羊玻璃";
                if (meta == 14) return "红羊玻璃";
                if (meta == 15) return "黑羊玻璃";
                return "白色玻璃";
            case 96:
                return "木质活板门";
            case 97:
                if (meta == 1) return "被虫蚀的圆石";
                if (meta == 2) return "被虫蚀的石砖";
                if (meta == 3) return "被虫蚀的苔石砖";
                if (meta == 4) return "被虫蚀的裂石砖";
                if (meta == 5) return "被虫蚀的錾制石砖";
                if (meta == 6) return "粉红色玻璃";
                return "被虫蚀的石头";
            case 98:
                if (meta == 1) return "苔石砖";
                if (meta == 2) return "裂石砖";
                if (meta == 3) return "錾制石砖";
                return "石砖";
            case 99:
                return "棕色蘑菇方块";
            case 100:
                return "红色蘑菇方块";
            case 101:
                return "铁栏杆";
            case 102:
                return "玻璃板";
            case 103:
                return "西瓜";
            case 104:
                //TODO:
                return "";
            case 105:
                return "";
            case 106:
                return "";
            case 107:
                return "";
            case 108:
                return "";
            case 109:
                return "";
            case 110:
                return "";
            case 111:
                return "";
            case 112:
                return "";
            case 113:
                return "";
            case 114:
                return "";
            case 115:
                return "";
            case 116:
                return "";
            case 117:
                return "";
            case 118:
                return "";
            case 119:
                return "";
            case 120:
                return "";
            case 121:
                return "";
            case 122:
                return "";
            case 123:
                return "";
            case 124:
                return "";
            case 125:
                return "双层橡木板";
            case 126:
                return "";
            case 127:
                return "";
            case 128:
                return "";
            case 129:
                return "绿宝石矿";
            case 130:
                return "末影箱";
            case 131:
                return "";
            case 132:
                return "";
            case 133:
                return "绿宝石";
            case 134:
                return "";
            case 135:
                return "";
            case 136:
                return "";
            case 137:
                return "";
            case 138:
                return "信标";
            case 139:
                return "";
            case 140:
                return "";
            case 141:
                return "";
            case 142:
                return "";
            case 143:
                return "";
            case 144:
                return "";
            case 145:
                return "";
            case 146:
                return "";
            case 147:
                return "";
            case 148:
                return "";
            case 149:
                return "";
            case 150:
                return "";
            case 151:
                return "";
            case 152:
                return "";
            case 153:
                return "";
            case 154:
                return "";
            case 155:
                return "";
            case 156:
                return "";
            case 157:
                return "";
            case 158:
                return "";
            case 159:
                return "";
            case 160:
                return "";
            case 161:
                return "";
            case 162:
                return "";
            case 163:
                return "";
            case 164:
                return "";
            case 165:
                return "";
            case 166:
                return "";
            case 167:
                return "";
            case 168:
                return "";
            case 169:
                return "";
            case 170:
                return "";
            case 171:
                return "";
            case 172:
                return "";
            case 173:
                return "";
            case 174:
                return "";
            case 175:
                return "";
            case 176:
                return "";
            case 177:
                return "";
            case 178:
                return "";
            case 179:
                return "";
            case 180:
                return "";
            case 181:
                return "";
            case 182:
                return "";
            case 183:
                return "";
            case 184:
                return "";
            case 185:
                return "";
            case 186:
                return "";
            case 187:
                return "";
            case 188:
                return "";
            case 189:
                return "";
            case 190:
                return "";
            case 191:
                return "";
            case 192:
                return "";
            case 193:
                return "";
            case 194:
                return "";
            case 195:
                return "";
            case 196:
                return "";
            case 197:
                return "";
            case 198:
                return "";
            case 199:
                return "";
            case 200:
                return "";
            case 201:
                return "";
            case 202:
                return "";
            case 203:
                return "";
            case 204:
                return "";
            case 205:
                return "";
            case 206:
                return "";
            case 207:
                return "";
            case 208:
                return "";
            case 209:
                return "";
            case 210:
                return "";
            case 211:
                return "";
            case 212:
                return "";
            case 213:
                return "";
            case 214:
                return "";
            case 215:
                return "";
            case 216:
                return "";
            case 217:
                return "";
            case 218:
                return "";
            case 219:
                return "";
            case 220:
                return "";
            case 221:
                return "";
            case 222:
                return "";
            case 223:
                return "";
            case 224:
                return "";
            case 225:
                return "";
            case 226:
                return "";
            case 227:
                return "";
            case 228:
                return "";
            case 229:
                return "";
            case 230:
                return "";
            case 231:
                return "";
            case 232:
                return "";
            case 233:
                return "";
            case 234:
                return "";
            case 235:
                return "";
            case 236:
                return "";
            case 237:
                return "";
            case 238:
                return "";
            case 239:
                return "";
            case 240:
                return "";
            case 241:
                return "";
            case 242:
                return "";
            case 243:
                return "";
            case 244:
                return "";
            case 245:
                return "";
            case 246:
                return "";
            case 247:
                return "";
            case 248:
                return "";
            case 249:
                return "";
            case 250:
                return "";
            case 251:
                return "";
            case 252:
                return "";
            case 253:
                return "";
            case 254:
                return "";
            case 255:
                return "";
            case 256:
                return "";
            case 257:
                return "";
            case 258:
                return "";
            case 259:
                return "";
            case 260:
                return "";
            case 261:
                return "";
            case 262:
                return "";
            case 263:
                if (meta == 1) return "木炭";
                return "煤炭";
            case 264:
                return "钻石";
            case 265:
                return "铁锭";
            case 266:
                return "金锭";
            case 267:
                return "";
            case 268:
                return "";
            case 269:
                return "";
            case 270:
                return "";
            case 271:
                return "";
            case 272:
                return "";
            case 273:
                return "";
            case 274:
                return "";
            case 275:
                return "";
            case 276:
                return "";
            case 277:
                return "";
            case 278:
                return "";
            case 279:
                return "";
            case 280:
                return "";
            case 281:
                return "";
            case 282:
                return "";
            case 283:
                return "";
            case 284:
                return "";
            case 285:
                return "";
            case 286:
                return "";
            case 287:
                return "";
            case 288:
                return "";
            case 289:
                return "";
            case 290:
                return "";
            case 291:
                return "";
            case 292:
                return "";
            case 293:
                return "";
            case 294:
                return "";
            case 295:
                return "";
            case 296:
                return "";
            case 297:
                return "";
            case 298:
                return "";
            case 299:
                return "";
            case 300:
                return "";
            case 301:
                return "";
            case 302:
                return "";
            case 303:
                return "";
            case 304:
                return "";
            case 305:
                return "";
            case 306:
                return "";
            case 307:
                return "";
            case 308:
                return "";
            case 309:
                return "";
            case 310:
                return "";
            case 311:
                return "";
            case 312:
                return "";
            case 313:
                return "";
            case 314:
                return "";
            case 315:
                return "";
            case 316:
                return "";
            case 317:
                return "";
            case 318:
                return "";
            case 319:
                return "";
            case 320:
                return "";
            case 321:
                return "";
            case 322:
                return "";
            case 323:
                return "";
            case 324:
                return "";
            case 325:
                return "";
            case 326:
                return "";
            case 327:
                return "";
            case 328:
                return "";
            case 329:
                return "";
            case 330:
                return "";
            case 331:
                return "红石粉";
            case 332:
                return "";
            case 333:
                return "";
            case 334:
                return "";
            case 335:
                return "";
            case 336:
                return "";
            case 337:
                return "";
            case 338:
                return "";
            case 339:
                return "";
            case 340:
                return "";
            case 341:
                return "";
            case 342:
                return "";
            case 343:
                return "";
            case 344:
                return "";
            case 345:
                return "";
            case 346:
                return "";
            case 347:
                return "";
            case 348:
                return "";
            case 349:
                return "";
            case 350:
                return "";
            case 351:
                if (meta == 1) return "玫瑰红";
                if (meta == 2) return "仙人掌绿";
                if (meta == 3) return "可可豆";
                if (meta == 4) return "青金石";
                if (meta == 5) return "紫色染料";
                if (meta == 6) return "青色染料";
                if (meta == 7) return "淡灰色染料";
                if (meta == 8) return "灰色染料";
                if (meta == 9) return "粉红色染料";
                if (meta == 10) return "黄绿色染料";
                if (meta == 11) return "蒲公英黄";
                if (meta == 12) return "淡蓝色染料";
                if (meta == 13) return "品红色染料";
                if (meta == 14) return "橙色染料";
                if (meta == 15) return "骨粉";
                return "墨囊";
            case 352:
                return "";
            case 353:
                return "";
            case 354:
                return "";
            case 355:
                return "";
            case 356:
                return "";
            case 357:
                return "";
            case 358:
                return "";
            case 359:
                return "";
            case 360:
                return "";
            case 361:
                return "";
            case 362:
                return "";
            case 363:
                return "";
            case 364:
                return "";
            case 365:
                return "";
            case 366:
                return "";
            case 367:
                return "";
            case 368:
                return "";
            case 369:
                return "";
            case 370:
                return "";
            case 371:
                return "";
            case 372:
                return "";
            case 373:
                return "";
            case 374:
                return "";
            case 375:
                return "";
            case 376:
                return "";
            case 377:
                return "";
            case 378:
                return "";
            case 379:
                return "";
            case 380:
                return "";
            case 381:
                return "";
            case 382:
                return "";
            case 383:
                return "";
            case 384:
                return "";
            case 385:
                return "";
            case 386:
                return "";
            case 387:
                return "";
            case 388:
                return "绿宝石";
            case 389:
                return "";
            default:
                return item.getName();
        }
    }

    public static void checkPluginUpdate(Plugin plugin) {
        ExtensionMain mainPlugin = ExtensionMain.getInstance();
        mainPlugin.getServer().getScheduler().scheduleTask(mainPlugin, new CheckPluginUpdateTask(mainPlugin, plugin), true);
    }
}
