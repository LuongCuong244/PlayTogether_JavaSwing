/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAndProperties;

import KeyBoardAndMouse.ItemAutoFishing;
import KeyBoardAndMouse.OneLineMouse;
import Location.PointButton;
import Thread.ThreadActivateMouse;
import Thread.ThreadManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import playtogether.JFrameCustomMouse;
import playtogether.JFrameMain;
import playtogether.JPanelTable;

/**
 *
 * @author Administrator
 */
public class Data {

    private static String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + "data.bin";
    private static String pathJsonPointMouse = System.getProperty("user.dir") + File.separator + "data" + File.separator + "listPointMouse.json";
    private static String pathJsonAutoGoFishing = System.getProperty("user.dir") + File.separator + "data" + File.separator + "AutoFishing.json";
    private static String pathData = System.getProperty("user.dir") + File.separator + "data";

    public static boolean readData() {

        File file = new File(path);
        if (file.exists() == false) {
            return false;
        }
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
//            JFrameMain.SCREEN_WIDTH = Integer.parseInt(br.readLine());
//            JFrameMain.SCREEN_HEIGHT = Integer.parseInt(br.readLine());
            JFrameMain.pointJFrame = new Point(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
            Properties.width_Move_Rect_ExclamationMark = Integer.parseInt(br.readLine());
            Properties.height_Move_Rect_ExclamationMark = Integer.parseInt(br.readLine());

            Properties.pointMoveRectStartX = Integer.parseInt(br.readLine());
            Properties.pointMoveRectStartY = Integer.parseInt(br.readLine());
            JPanelTable.pointDrawRectStart.setLocation(Properties.pointMoveRectStartX, Properties.pointMoveRectStartY);
            JPanelTable.pointDrawRectEnd.setLocation(Properties.pointMoveRectStartX + Properties.width_Move_Rect_ExclamationMark, Properties.pointMoveRectStartY + Properties.height_Move_Rect_ExclamationMark);

            Properties.pointButtonBalo_X = Float.parseFloat(br.readLine());
            Properties.pointButtonBalo_Y = Float.parseFloat(br.readLine());
            PointButton.pointBalo.setLocation(Properties.pointButtonBalo_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonBalo_Y * JFrameMain.SCREEN_HEIGHT);

            Properties.pointButtonCoin_X = Float.parseFloat(br.readLine());
            Properties.pointButtonCoin_Y = Float.parseFloat(br.readLine());
            PointButton.pointCoin.setLocation(Properties.pointButtonCoin_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonCoin_Y * JFrameMain.SCREEN_HEIGHT);

            Properties.pointButtonDragFish_X = Float.parseFloat(br.readLine());
            Properties.pointButtonDragFish_Y = Float.parseFloat(br.readLine());
            PointButton.pointDragFish.setLocation(Properties.pointButtonDragFish_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonDragFish_Y * JFrameMain.SCREEN_HEIGHT);

            Properties.pointButtonExit_X = Float.parseFloat(br.readLine());
            Properties.pointButtonExit_Y = Float.parseFloat(br.readLine());
            PointButton.pointExit.setLocation(Properties.pointButtonExit_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonExit_Y * JFrameMain.SCREEN_HEIGHT);

            Properties.pointButtonFix_X = Float.parseFloat(br.readLine());
            Properties.pointButtonFix_Y = Float.parseFloat(br.readLine());
            PointButton.pointFix.setLocation(Properties.pointButtonFix_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonFix_Y * JFrameMain.SCREEN_HEIGHT);

            Properties.pointButtonGarbage_X = Float.parseFloat(br.readLine());
            Properties.pointButtonGarbage_Y = Float.parseFloat(br.readLine());
            PointButton.pointGarbage.setLocation(Properties.pointButtonGarbage_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonGarbage_Y * JFrameMain.SCREEN_HEIGHT);

            Properties.pointButtonGoFishing_X = Float.parseFloat(br.readLine());
            Properties.pointButtonGoFishing_Y = Float.parseFloat(br.readLine());
            PointButton.pointGoFishing.setLocation(Properties.pointButtonGoFishing_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonGoFishing_Y * JFrameMain.SCREEN_HEIGHT);

            Properties.pointButtonKeepFish_X = Float.parseFloat(br.readLine());
            Properties.pointButtonKeepFish_Y = Float.parseFloat(br.readLine());
            PointButton.pointKeepFish.setLocation(Properties.pointButtonKeepFish_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonKeepFish_Y * JFrameMain.SCREEN_HEIGHT);

            Properties.pointButtonTool_X = Float.parseFloat(br.readLine());
            Properties.pointButtonTool_Y = Float.parseFloat(br.readLine());
            PointButton.pointTool.setLocation(Properties.pointButtonTool_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonTool_Y * JFrameMain.SCREEN_HEIGHT);

            Properties.pointButtonChat_X = Float.parseFloat(br.readLine());
            Properties.pointButtonChat_Y = Float.parseFloat(br.readLine());
            PointButton.pointChat.setLocation(Properties.pointButtonChat_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonChat_Y * JFrameMain.SCREEN_HEIGHT);

            JFrameCustomMouse.pMouseGoUpStart.setLocation(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));

            PointButton.radiusBalo = Integer.parseInt(br.readLine());
            PointButton.radiusChat = Integer.parseInt(br.readLine());
            PointButton.radiusCoin = Integer.parseInt(br.readLine());
            PointButton.radiusDragFish = Integer.parseInt(br.readLine());
            PointButton.radiusExit = Integer.parseInt(br.readLine());
            PointButton.radiusFix = Integer.parseInt(br.readLine());
            PointButton.radiusGarbage = Integer.parseInt(br.readLine());
            PointButton.radiusGoFishing = Integer.parseInt(br.readLine());
            PointButton.radiusKeepFish = Integer.parseInt(br.readLine());
            PointButton.radiusTool = Integer.parseInt(br.readLine());
            
            ThreadManager.isRunTime = Boolean.parseBoolean(br.readLine());
            ThreadManager.isColorful = Boolean.parseBoolean(br.readLine());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        File file1 = new File(pathJsonPointMouse);
        if (file1.exists() == false) {
            return false;
        }
        FileReader fr1 = null;
        try {
            fr1 = new FileReader(pathJsonPointMouse);
            Type type = new TypeToken<ArrayList<OneLineMouse>>() {
            }.getType();
            Gson gson = new Gson();
            JFrameCustomMouse.listMouseLine = gson.fromJson(fr1, type);
        } catch (Exception e) {
        } finally {
            try {
                fr1.close();
            } catch (IOException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        File file2 = new File(pathJsonAutoGoFishing);
        if (file2.exists() == false) {
            return false;
        }
        FileReader fr2 = null;
        try {
            fr2 = new FileReader(pathJsonAutoGoFishing);
            Type type = new TypeToken<ArrayList<ItemAutoFishing>>() {
            }.getType();
            Gson gson = new Gson();
            JFrameCustomMouse.listAutoFishing = gson.fromJson(fr2, type);
        } catch (Exception e) {
        } finally {
            try {
                fr2.close();
            } catch (IOException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    public static void writeData() {
        File file = new File(path);
        if (file.exists() == false) {
            try {
                File file1 = new File(pathData);
                if (file1.exists() == false) {
                    file1.mkdirs();
                }
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
//            bw.write(JFrameMain.SCREEN_WIDTH + "\n");
//            bw.write(JFrameMain.SCREEN_HEIGHT + "\n");
            bw.write(JFrameMain.pointJFrame.x + "\n");
            bw.write(JFrameMain.pointJFrame.y + "\n");
            bw.write(Properties.width_Move_Rect_ExclamationMark + "\n");
            bw.write(Properties.height_Move_Rect_ExclamationMark + "\n");
            bw.write(JPanelTable.pointDrawRectStart.x + "\n");
            bw.write(JPanelTable.pointDrawRectStart.y + "\n");

            bw.write(Properties.pointButtonBalo_X + "\n");
            bw.write(Properties.pointButtonBalo_Y + "\n");

            bw.write(Properties.pointButtonCoin_X + "\n");
            bw.write(Properties.pointButtonCoin_Y + "\n");

            bw.write(Properties.pointButtonDragFish_X + "\n");
            bw.write(Properties.pointButtonDragFish_Y + "\n");

            bw.write(Properties.pointButtonExit_X + "\n");
            bw.write(Properties.pointButtonExit_Y + "\n");

            bw.write(Properties.pointButtonFix_X + "\n");
            bw.write(Properties.pointButtonFix_Y + "\n");

            bw.write(Properties.pointButtonGarbage_X + "\n");
            bw.write(Properties.pointButtonGarbage_Y + "\n");

            bw.write(Properties.pointButtonGoFishing_X + "\n");
            bw.write(Properties.pointButtonGoFishing_Y + "\n");

            bw.write(Properties.pointButtonKeepFish_X + "\n");
            bw.write(Properties.pointButtonKeepFish_Y + "\n");

            bw.write(Properties.pointButtonTool_X + "\n");
            bw.write(Properties.pointButtonTool_Y + "\n");

            bw.write(Properties.pointButtonChat_X + "\n");
            bw.write(Properties.pointButtonChat_Y + "\n");

            bw.write(JFrameCustomMouse.pMouseGoUpStart.x + "\n");
            bw.write(JFrameCustomMouse.pMouseGoUpStart.y + "\n");

            bw.write(PointButton.radiusBalo + "\n");
            bw.write(PointButton.radiusChat + "\n");
            bw.write(PointButton.radiusCoin + "\n");
            bw.write(PointButton.radiusDragFish + "\n");
            bw.write(PointButton.radiusExit + "\n");
            bw.write(PointButton.radiusFix + "\n");
            bw.write(PointButton.radiusGarbage + "\n");
            bw.write(PointButton.radiusGoFishing + "\n");
            bw.write(PointButton.radiusKeepFish + "\n");
            bw.write(PointButton.radiusTool + "\n");
            
            bw.write(ThreadManager.isRunTime + "\n");
            bw.write(ThreadManager.isColorful + "\n");
        } catch (Exception e) {
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        File file1 = new File(pathJsonPointMouse);
        if (file1.exists() == false) {
            try {
                file1.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        FileWriter fw = null;
        try {
            fw = new FileWriter(file1);
            Type type = new TypeToken<ArrayList<OneLineMouse>>() {
            }.getType();
            Gson gson = new Gson();
            gson.toJson(JFrameCustomMouse.listMouseLine, type, fw);
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        File file2 = new File(pathJsonAutoGoFishing);
        if (file2.exists() == false) {
            try {
                file2.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        FileWriter fw2 = null;
        try {
            fw2 = new FileWriter(file2);
            Type type = new TypeToken<ArrayList<ItemAutoFishing>>() {
            }.getType();
            Gson gson = new Gson();
            int i = 0;
            ArrayList<ItemAutoFishing> list = new ArrayList<ItemAutoFishing>();
            while (i < JFrameCustomMouse.listAutoFishing.size()) {
                ItemAutoFishing item = JFrameCustomMouse.listAutoFishing.get(i);
                if ((item.getDirection() == ItemAutoFishing.TURN_DOWN) || (item.getDirection() == ItemAutoFishing.TURN_UP)) {
                    int j = i + 1;
                    int totalChangeHeight;
                    if (item.getDirection() == ItemAutoFishing.TURN_DOWN) {
                        totalChangeHeight = item.getValue();
                    } else {
                        totalChangeHeight = -item.getValue();
                    }
                    if (j < JFrameCustomMouse.listAutoFishing.size()) {
                        while ((JFrameCustomMouse.listAutoFishing.get(j).getDirection() == ItemAutoFishing.TURN_DOWN) || (JFrameCustomMouse.listAutoFishing.get(j).getDirection() == ItemAutoFishing.TURN_UP)) {
                            ItemAutoFishing itemNext = JFrameCustomMouse.listAutoFishing.get(j);
                            if (itemNext.getDirection() == ItemAutoFishing.TURN_DOWN) {
                                totalChangeHeight += itemNext.getValue();
                            } else {
                                totalChangeHeight -= itemNext.getValue();
                            }
                            j++;
                            if (j == JFrameCustomMouse.listAutoFishing.size()) {
                                break;
                            };
                        }
                        i = j - 1;
                    }
                    if (totalChangeHeight > 0) {
                        list.add(new ItemAutoFishing(ItemAutoFishing.TURN_DOWN, Math.abs(totalChangeHeight)));
                    } else if (totalChangeHeight < 0) {
                        list.add(new ItemAutoFishing(ItemAutoFishing.TURN_UP, Math.abs(totalChangeHeight)));
                    }
                } else if ((item.getDirection() == ItemAutoFishing.TURN_LEFT) || (item.getDirection() == ItemAutoFishing.TURN_RIGHT)) {
                    int j = i + 1;
                    int totalChangeWidth;
                    if (item.getDirection() == ItemAutoFishing.TURN_RIGHT) {
                        totalChangeWidth = item.getValue();
                    } else {
                        totalChangeWidth = -item.getValue();
                    }
                    if (j < JFrameCustomMouse.listAutoFishing.size()) {
                        while ((JFrameCustomMouse.listAutoFishing.get(j).getDirection() == ItemAutoFishing.TURN_RIGHT) || (JFrameCustomMouse.listAutoFishing.get(j).getDirection() == ItemAutoFishing.TURN_LEFT)) {
                            ItemAutoFishing itemNext = JFrameCustomMouse.listAutoFishing.get(j);
                            if (itemNext.getDirection() == ItemAutoFishing.TURN_RIGHT) {
                                totalChangeWidth += itemNext.getValue();
                            } else {
                                totalChangeWidth -= itemNext.getValue();
                            }
                            j++;
                            if (j == JFrameCustomMouse.listAutoFishing.size()) {
                                break;
                            };
                        }
                        i = j - 1;
                    }
                    if (totalChangeWidth > 0) {
                        list.add(new ItemAutoFishing(ItemAutoFishing.TURN_RIGHT, Math.abs(totalChangeWidth)));
                    } else if (totalChangeWidth < 0) {
                        list.add(new ItemAutoFishing(ItemAutoFishing.TURN_LEFT, Math.abs(totalChangeWidth)));
                    }
                } else if ((item.getDirection() == ItemAutoFishing.GO_UP) || (item.getDirection() == ItemAutoFishing.GO_DOWN)) {
                    int j = i + 1;
                    int totalChangeWidth;
                    if (item.getDirection() == ItemAutoFishing.GO_UP) {
                        totalChangeWidth = item.getValue();
                    } else {
                        totalChangeWidth = -item.getValue();
                    }
                    if (j < JFrameCustomMouse.listAutoFishing.size()) {
                        while ((JFrameCustomMouse.listAutoFishing.get(j).getDirection() == ItemAutoFishing.GO_UP) || (JFrameCustomMouse.listAutoFishing.get(j).getDirection() == ItemAutoFishing.GO_DOWN)) {
                            ItemAutoFishing itemNext = JFrameCustomMouse.listAutoFishing.get(j);
                            if (itemNext.getDirection() == ItemAutoFishing.GO_UP) {
                                totalChangeWidth += itemNext.getValue();
                            } else {
                                totalChangeWidth -= itemNext.getValue();
                            }
                            j++;
                            if (j == JFrameCustomMouse.listAutoFishing.size()) {
                                break;
                            };
                        }
                        i = j - 1;
                    }
                    if (totalChangeWidth > 0) {
                        list.add(new ItemAutoFishing(ItemAutoFishing.GO_UP, Math.abs(totalChangeWidth)));
                    } else if (totalChangeWidth < 0) {
                        list.add(new ItemAutoFishing(ItemAutoFishing.GO_DOWN, Math.abs(totalChangeWidth)));
                    }
                }
                i++;
            }
            gson.toJson(list, type, fw2);
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw2.close();
            } catch (IOException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
