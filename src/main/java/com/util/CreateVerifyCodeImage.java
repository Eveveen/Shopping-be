package com.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CreateVerifyCodeImage {
	
	public void create(){
		
		int width = 78;
		int height = 20;
		//����ͼƬ����
		BufferedImage bim = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//��ȡͼƬ��ͼ����
		Graphics g = bim.getGraphics();
				
		//�������������ɫ���������ͼƬ
		Random rm = new Random();
		
		g.setColor(new Color(rm.nextInt(155),rm.nextInt(220),rm.nextInt(255)));
				g.fillRect(0,0, width, height);
				
		StringBuffer sbf = new StringBuffer("");
		for(int i=0;i<4;i++){//ѭ���������
			g.setColor(new Color(rm.nextInt(88),rm.nextInt(188),rm.nextInt(255)));
			g.setFont(new Font("Dotum",Font.BOLD|Font.ITALIC,22));
			int n = rm.nextInt(10);
			sbf.append(n);
			g.drawString(""+n,i*16+5, 18);
		}
		
		System.out.println(g);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateVerifyCodeImage c = new CreateVerifyCodeImage();
		c.create();
	}

}
