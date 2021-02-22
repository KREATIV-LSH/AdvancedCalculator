package ch.lsh.advancedcalculator.calculator.impl;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.lsh.advancedcalculator.calculator.Calculator;

public class CalculatorAreaVolumeCircumference extends Calculator implements ActionListener, KeyListener {

	public static BigDecimal PI = new BigDecimal(3.141592653589793238462643383279502);

	private static String lastInUse = "Rectangle";
	private JFrame frame;
	private JPanel panel;
	private static JLabel modeLabel;

	private static JLabel areaEqLabel;
	private static JLabel volumeEqLabel;
	private static JLabel cirumferencEqLabel;

	public static HashMap<String, String> equationMapArea = new HashMap<String, String>();
	public static HashMap<String, String> equationMapVolume = new HashMap<String, String>();
	public static HashMap<String, String> equationMapCircumference = new HashMap<String, String>();

	private static boolean recToggeld = true;
	private static boolean cicToggeld = false;
	private static boolean ovaToggeld = false;
	private static boolean boxToggeld = false;
	private static boolean sphToggeld = false;
	private static boolean cylToggeld = false;
	private static boolean conToggeld = false;

	public CalculatorAreaVolumeCircumference() {
		super("Area, Volume, Circumference", 400, 800);
	}

	private static JLabel hRectLabel;
	private static JLabel wRectLabel;
	private static JTextField hRectField;
	private static JTextField wRectField;

	private static JLabel radiusLabel;
	private static JTextField radiusField;

	private static JLabel aOvalLabel;
	private static JTextField aOvalField;
	private static JLabel bOvalLabel;
	private static JTextField bOvalField;

	private static JLabel lBoxLabel;
	private static JTextField lBoxField;

	private static JLabel areaLabel;
	private static JTextField areaField;

	private static JLabel volumeLabel;
	private static JTextField volumeField;

	private static JLabel circumferenceLabel;
	private static JTextField circumferenceField;

	@Override
	public JFrame execute() {
		initEquationMaps();
		frame = new JFrame("Advanced Calculator - " + getCalculator());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(getWidth(), getHeight());
		frame.setResizable(false);
		panel = new JPanel();
		panel.setLayout(null);

		JLabel objectLabel = new JLabel("Mode:");
		objectLabel.setLocation(10, 5);
		objectLabel.setSize(60, 25);
		objectLabel.setForeground(new Color(214, 237, 23));
		panel.add(objectLabel);

		areaLabel = new JLabel("Area:");
		areaLabel.setLocation(400, 100);
		areaLabel.setSize(60, 25);
		areaLabel.setForeground(new Color(214, 237, 23));
		panel.add(areaLabel);

		areaField = new JTextField("NaN");
		areaField.setLocation(435, 103);
		areaField.setSize(285, 20);
		areaField.setEditable(false);
		panel.add(areaField);

		volumeLabel = new JLabel("Volume:");
		volumeLabel.setLocation(400, 125);
		volumeLabel.setSize(60, 25);
		volumeLabel.setForeground(new Color(214, 237, 23));
		panel.add(volumeLabel);

		volumeField = new JTextField("NaN");
		volumeField.setLocation(450, 128);
		volumeField.setSize(270, 20);
		volumeField.setEditable(false);
		panel.add(volumeField);

		circumferenceLabel = new JLabel("Circumference:");
		circumferenceLabel.setLocation(400, 150);
		circumferenceLabel.setSize(100, 25);
		circumferenceLabel.setForeground(new Color(214, 237, 23));
		panel.add(circumferenceLabel);

		circumferenceField = new JTextField("NaN");
		circumferenceField.setLocation(490, 153);
		circumferenceField.setSize(230, 20);
		circumferenceField.setEditable(false);
		panel.add(circumferenceField);

		/*
		 * ----- START INTERFACES -----
		 */

		// Rectangel
		hRectLabel = new JLabel("Height:");
		hRectLabel.setLocation(10, 125);
		hRectLabel.setSize(60, 25);
		hRectLabel.setForeground(new Color(214, 237, 23));
		hRectLabel.setVisible(recToggeld);
		panel.add(hRectLabel);

		wRectLabel = new JLabel("Width:");
		wRectLabel.setLocation(10, 100);
		wRectLabel.setSize(60, 25);
		wRectLabel.setForeground(new Color(214, 237, 23));
		wRectLabel.setVisible(recToggeld);
		panel.add(wRectLabel);

		hRectField = new JTextField("");
		hRectField.setLocation(50, 128);
		hRectField.setSize(200, 20);
		hRectField.setVisible(recToggeld);
		hRectField.setColumns(50);
		hRectField.addKeyListener(this);
		panel.add(hRectField);

		wRectField = new JTextField("");
		wRectField.setLocation(50, 103);
		wRectField.setSize(200, 20);
		wRectField.setVisible(recToggeld);
		wRectField.addKeyListener(this);
		panel.add(wRectField);

		// Circle
		radiusLabel = new JLabel("Radius:");
		radiusLabel.setLocation(10, 100);
		radiusLabel.setSize(60, 25);
		radiusLabel.setForeground(new Color(214, 237, 23));
		radiusLabel.setVisible(cicToggeld);
		panel.add(radiusLabel);

		radiusField = new JTextField("");
		radiusField.setLocation(51, 103);
		radiusField.setSize(200, 20);
		radiusField.setVisible(cicToggeld);
		radiusField.addKeyListener(this);
		panel.add(radiusField);

		// Oval
		aOvalLabel = new JLabel("A:");
		aOvalLabel.setLocation(10, 100);
		aOvalLabel.setSize(60, 25);
		aOvalLabel.setForeground(new Color(214, 237, 23));
		aOvalLabel.setVisible(ovaToggeld);
		panel.add(aOvalLabel);

		bOvalLabel = new JLabel("B:");
		bOvalLabel.setLocation(10, 125);
		bOvalLabel.setSize(60, 25);
		bOvalLabel.setForeground(new Color(214, 237, 23));
		bOvalLabel.setVisible(ovaToggeld);
		panel.add(bOvalLabel);

		aOvalField = new JTextField("");
		aOvalField.setLocation(30, 103);
		aOvalField.setSize(200, 20);
		aOvalField.setVisible(ovaToggeld);
		aOvalField.addKeyListener(this);
		panel.add(aOvalField);

		bOvalField = new JTextField("");
		bOvalField.setLocation(30, 128);
		bOvalField.setSize(200, 20);
		bOvalField.setVisible(ovaToggeld);
		bOvalField.addKeyListener(this);
		panel.add(bOvalField);

		// Box
		lBoxLabel = new JLabel("Length:");
		lBoxLabel.setLocation(10, 150);
		lBoxLabel.setSize(60, 25);
		lBoxLabel.setForeground(new Color(214, 237, 23));
		lBoxLabel.setVisible(boxToggeld);
		panel.add(lBoxLabel);

		lBoxField = new JTextField("");
		lBoxField.setLocation(51, 153);
		lBoxField.setSize(200, 20);
		lBoxField.setVisible(boxToggeld);
		lBoxField.addKeyListener(this);
		panel.add(lBoxField);

		/*
		 * ----- STOP INTERFACES -----
		 */

		/*
		 * ----- START OBJECTS -----
		 */

		JButton rectangleButton = new JButton("Rectangle");
		rectangleButton.setLocation(10, 35);
		rectangleButton.setSize(100, 30);
		rectangleButton.setBackground(Color.BLACK);
		rectangleButton.setForeground(new Color(214, 237, 23));
		rectangleButton.addActionListener(this);
		panel.add(rectangleButton);

		JButton circleButton = new JButton("Circle");
		circleButton.setLocation(120, 35);
		circleButton.setSize(100, 30);
		circleButton.setBackground(Color.BLACK);
		circleButton.setForeground(new Color(214, 237, 23));
		circleButton.addActionListener(this);
		panel.add(circleButton);

		JButton ovalButton = new JButton("Oval");
		ovalButton.setLocation(230, 35);
		ovalButton.setSize(100, 30);
		ovalButton.setBackground(Color.BLACK);
		ovalButton.setForeground(new Color(214, 237, 23));
		ovalButton.addActionListener(this);
		panel.add(ovalButton);

		JButton boxButton = new JButton("Box");
		boxButton.setLocation(340, 35);
		boxButton.setSize(100, 30);
		boxButton.setBackground(Color.BLACK);
		boxButton.setForeground(new Color(214, 237, 23));
		boxButton.addActionListener(this);
		panel.add(boxButton);

		JButton sphereButton = new JButton("Sphere");
		sphereButton.setLocation(450, 35);
		sphereButton.setSize(100, 30);
		sphereButton.setBackground(Color.BLACK);
		sphereButton.setForeground(new Color(214, 237, 23));
		sphereButton.addActionListener(this);
		panel.add(sphereButton);

		JButton cylinderButton = new JButton("Cylinder");
		cylinderButton.setLocation(560, 35);
		cylinderButton.setSize(100, 30);
		cylinderButton.setBackground(Color.BLACK);
		cylinderButton.setForeground(new Color(214, 237, 23));
		cylinderButton.addActionListener(this);
		panel.add(cylinderButton);

		JButton coneButton = new JButton("Cone");
		coneButton.setLocation(670, 35);
		coneButton.setSize(100, 30);
		coneButton.setBackground(Color.BLACK);
		coneButton.setForeground(new Color(214, 237, 23));
		coneButton.addActionListener(this);
		panel.add(coneButton);

		/*
		 * ----- STOP OBJECTS -----
		 */

		modeLabel = new JLabel("Mode: " + lastInUse);
		modeLabel.setLocation(10, 70);
		modeLabel.setSize(200, 25);
		modeLabel.setForeground(new Color(214, 237, 23));
		panel.add(modeLabel);

		areaEqLabel = new JLabel("Area: " + getAreaEqForMode(lastInUse));
		areaEqLabel.setLocation(200, 70);
		areaEqLabel.setSize(200, 25);
		areaEqLabel.setForeground(new Color(214, 237, 23));
		panel.add(areaEqLabel);

		volumeEqLabel = new JLabel("Volume: " + getVolumeEqForMode(lastInUse));
		volumeEqLabel.setLocation(390, 70);
		volumeEqLabel.setSize(200, 25);
		volumeEqLabel.setForeground(new Color(214, 237, 23));
		panel.add(volumeEqLabel);

		cirumferencEqLabel = new JLabel("Circumference: " + getCircumferenceEqForMode(lastInUse));
		cirumferencEqLabel.setLocation(580, 70);
		cirumferencEqLabel.setSize(200, 25);
		cirumferencEqLabel.setForeground(new Color(214, 237, 23));
		panel.add(cirumferencEqLabel);

		panel.setBackground(new Color(50, 50, 50));
		frame.add(panel);

		return frame;
	}

	public static void changeMode(String mode) {
		mode = mode.toLowerCase();
		lastInUse = mode.substring(0, 1).toUpperCase() + mode.substring(1);
		switch (mode) {
		case "rectangle":
			recToggeld = true;
			cicToggeld = false;
			ovaToggeld = false;
			boxToggeld = false;
			sphToggeld = false;
			cylToggeld = false;
			conToggeld = false;
			break;
		case "circle":
			recToggeld = false;
			cicToggeld = true;
			ovaToggeld = false;
			boxToggeld = false;
			sphToggeld = false;
			cylToggeld = false;
			conToggeld = false;
			break;
		case "oval":
			recToggeld = false;
			cicToggeld = false;
			ovaToggeld = true;
			boxToggeld = false;
			sphToggeld = false;
			cylToggeld = false;
			conToggeld = false;
			break;
		case "box":
			recToggeld = false;
			cicToggeld = false;
			ovaToggeld = false;
			boxToggeld = true;
			sphToggeld = false;
			cylToggeld = false;
			conToggeld = false;
			break;
		case "sphere":
			recToggeld = false;
			cicToggeld = false;
			ovaToggeld = false;
			boxToggeld = false;
			sphToggeld = true;
			cylToggeld = false;
			conToggeld = false;
			break;
		case "cylinder":
			recToggeld = false;
			cicToggeld = false;
			ovaToggeld = false;
			boxToggeld = false;
			sphToggeld = false;
			cylToggeld = true;
			conToggeld = false;
			break;
		case "cone":
			recToggeld = false;
			cicToggeld = false;
			ovaToggeld = false;
			boxToggeld = false;
			sphToggeld = false;
			cylToggeld = false;
			conToggeld = true;
			break;
		default:
			recToggeld = true;
			cicToggeld = false;
			ovaToggeld = false;
			boxToggeld = false;
			sphToggeld = false;
			cylToggeld = false;
			conToggeld = false;
			System.err.println(mode + " Is not handeld as a valid mode!");
			lastInUse = "Rectangle";
			break;
		}
		modeLabel.setText("Mode: " + lastInUse);
		areaEqLabel.setText("Area: " + getAreaEqForMode(lastInUse));
		volumeEqLabel.setText("Volume: " + getVolumeEqForMode(lastInUse));
		cirumferencEqLabel.setText("Circumference: " + getCircumferenceEqForMode(lastInUse));

		hRectField.setVisible(recToggeld | boxToggeld | cylToggeld | conToggeld);
		hRectLabel.setVisible(recToggeld | boxToggeld | cylToggeld | conToggeld);
		wRectField.setVisible(recToggeld | boxToggeld);
		wRectLabel.setVisible(recToggeld | boxToggeld);

		radiusField.setVisible(cicToggeld | conToggeld | sphToggeld | cylToggeld);
		radiusLabel.setVisible(cicToggeld | conToggeld | sphToggeld | cylToggeld);

		aOvalField.setVisible(ovaToggeld);
		aOvalLabel.setVisible(ovaToggeld);
		bOvalField.setVisible(ovaToggeld);
		bOvalLabel.setVisible(ovaToggeld);

		lBoxField.setVisible(boxToggeld);
		lBoxLabel.setVisible(boxToggeld);
	}

	private static void updateOutput() {
		String mode = lastInUse.toLowerCase();
		BigDecimal area = null;
		BigDecimal volume = null;
		BigDecimal circumference = null;
		String inputOfField = hRectField.getText() + wRectField.getText() + radiusField.getText() + aOvalField.getText()
				+ bOvalField.getText() + lBoxField.getText();
		String[] inputCharArray = inputOfField.split("");
		String[] allowedInput = "1234567890".split("");
		boolean valid = true;
		for (int i = 0; i < inputCharArray.length; i++) {
			for (int y = 0; y < allowedInput.length; y++) {
				if (inputCharArray[i] == allowedInput[y]) {
					break;
				} else if (inputCharArray[i].equalsIgnoreCase(".")) {
					if (i < inputCharArray.length) {
						if (inputCharArray[i + 1].equalsIgnoreCase(".")) {
							valid = false;
						}
					}
				} else {
					valid = false;
				}
			}
		}
//		if(!valid) {
//			Toolkit.getDefaultToolkit().beep();
//			return;
//		}
		BigDecimal height = null;
		BigDecimal width = null;
		BigDecimal radius = null;
		BigDecimal aOval = null;
		BigDecimal bOval = null;
		BigDecimal length = null;
		try {
			height = new BigDecimal(hRectField.getText());
			width = new BigDecimal(wRectField.getText());
			radius = new BigDecimal(radiusField.getText());
			aOval = new BigDecimal(aOvalField.getText());
			bOval = new BigDecimal(bOvalField.getText());
			length = new BigDecimal(lBoxField.getText());
		} catch (Exception e) {
		}
		
//		System.out.println(height + " " + hRectField.getText());

		try {
			System.out.println(mode);
			switch (mode) {
			case "rectangle":
				if (!(equationMapArea.get(lastInUse).equalsIgnoreCase("N3D")
						&& equationMapArea.get(lastInUse).equalsIgnoreCase("N2D"))) {
					area = height.multiply(width);
				}
				if (!(equationMapCircumference.get(lastInUse).equalsIgnoreCase("N3D")
						&& equationMapCircumference.get(lastInUse).equalsIgnoreCase("N2D"))) {
					circumference = height.add(width).multiply(new BigDecimal(2));
				}
				break;
			case "circle":
				if (!(equationMapArea.get(lastInUse).equalsIgnoreCase("N3D")
						&& equationMapArea.get(lastInUse).equalsIgnoreCase("N2D"))) {
					area = PI.multiply(radius.pow(2));
				}
				if (!(equationMapCircumference.get(lastInUse).equalsIgnoreCase("N3D")
						&& equationMapCircumference.get(lastInUse).equalsIgnoreCase("N2D"))) {
					circumference = new BigDecimal(2).multiply(PI).multiply(radius);
				}
				break;
			case "oval":
				if (!(equationMapArea.get(lastInUse).equalsIgnoreCase("N3D")
						&& equationMapArea.get(lastInUse).equalsIgnoreCase("N2D"))) {
					area = PI.multiply(aOval).multiply(bOval);
				}
				if (!(equationMapCircumference.get(lastInUse).equalsIgnoreCase("N3D")
						&& equationMapCircumference.get(lastInUse).equalsIgnoreCase("N2D"))) {
					BigDecimal root = aOval.pow(2).add(bOval.pow(2)).divide(new BigDecimal(2))
							.sqrt(MathContext.UNLIMITED);
					circumference = new BigDecimal(2).multiply(PI).multiply(root);
				}
				break;
			case "box":
				if (!(equationMapArea.get(lastInUse).equalsIgnoreCase("N3D")
						&& equationMapArea.get(lastInUse).equalsIgnoreCase("N2D"))) {
					area = new BigDecimal(2).multiply(height.multiply(width))
							.add(new BigDecimal(2).multiply(height.multiply(length)))
							.add(new BigDecimal(2).multiply(width.multiply(length)));
				}
				if (!(equationMapVolume.get(lastInUse).equalsIgnoreCase("N3D")
						&& equationMapVolume.get(lastInUse).equalsIgnoreCase("N2D"))) {
					volume = width.multiply(height).multiply(length);
				}
				break;
			case "sphere":
				if (!(equationMapArea.get(lastInUse).equalsIgnoreCase("N3D")
						&& equationMapArea.get(lastInUse).equalsIgnoreCase("N2D"))) {
					area = new BigDecimal(4).multiply(PI).multiply(radius.pow(2));
				}
				if (!(equationMapVolume.get(lastInUse).equalsIgnoreCase("N3D")
						&& equationMapVolume.get(lastInUse).equalsIgnoreCase("N2D"))) {
					volume = new BigDecimal(4).divide(new BigDecimal(3), MathContext.DECIMAL128).multiply(PI)
							.multiply(radius.pow(3));
				}
				break;
			case "cylinder":
				if (!(equationMapArea.get(lastInUse).equalsIgnoreCase("N3D")
						&& equationMapArea.get(lastInUse).equalsIgnoreCase("N2D"))) {
					area = new BigDecimal(2).multiply(PI).multiply(radius.pow(2))
							.add(height.multiply(new BigDecimal(2).multiply(PI).multiply(radius)));
				}
				if (!(equationMapVolume.get(lastInUse).equalsIgnoreCase("N3D")
						&& equationMapVolume.get(lastInUse).equalsIgnoreCase("N2D"))) {
					volume = PI.multiply(radius.pow(2)).multiply(height);
				}
				break;
			case "cone":
				if (!(equationMapArea.get(lastInUse).equalsIgnoreCase("N3D")
						&& equationMapArea.get(lastInUse).equalsIgnoreCase("N2D"))) {
					BigDecimal slant = radius.multiply(radius).add(height.multiply(height)).sqrt(MathContext.UNLIMITED);
					area = PI.multiply(radius).multiply(slant).add(PI.multiply(radius.pow(2)));
				}
				if (!(equationMapVolume.get(lastInUse).equalsIgnoreCase("N3D")
						&& equationMapVolume.get(lastInUse).equalsIgnoreCase("N2D"))) {
					volume = new BigDecimal(1).divide(new BigDecimal(3), MathContext.DECIMAL128).multiply(PI)
							.multiply(radius.pow(2)).multiply(height);
				}
				break;
			default:
				System.err.println(mode + " Is not handeld as a valid mode!");
				lastInUse = "Rectangle";
				updateOutput();
				break;
			}
		} catch (Exception e) {
//			e.printStackTrace();
		}
		if (area != null) {
			areaField.setText(area.toString());
		} else {
			areaField.setText("NaN");
		}
		if (volume != null) {
			volumeField.setText(volume.toString());
		} else {
			volumeField.setText("NaN");
		}
		if (circumference != null) {
			circumferenceField.setText(circumference.toString());
		} else {
			circumferenceField.setText("NaN");
		}
	}

	private static String getAreaEqForMode(String mode) {
		mode = mode.substring(0, 1).toUpperCase() + mode.substring(1);
		if (equationMapArea.containsKey(mode)) {
			return equationMapArea.get(mode);
		} else {
			return "NA";
		}
	}

	private static String getVolumeEqForMode(String mode) {
		mode = mode.substring(0, 1).toUpperCase() + mode.substring(1);
		if (equationMapVolume.containsKey(mode)) {
			return equationMapVolume.get(mode);
		} else {
			return "NA";
		}
	}

	private static String getCircumferenceEqForMode(String mode) {
		mode = mode.substring(0, 1).toUpperCase() + mode.substring(1);
		if (equationMapCircumference.containsKey(mode)) {
			return equationMapCircumference.get(mode);
		} else {
			return "NA";
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() instanceof JButton) {
			JButton button = (JButton) ae.getSource();
			if (!button.getText().equalsIgnoreCase(lastInUse)) {
				changeMode(button.getText());
			}
		}
	}

	private static void initEquationMaps() {
		// AREA
		equationMapArea.put("Rectangle", "h*w");
		equationMapArea.put("Circle", "π*r^2");
		equationMapArea.put("Oval", "πab");
		equationMapArea.put("Box", "2(h*w)+2(h*l)+2(w*l)");
		equationMapArea.put("Sphere", "4πr^2");
		equationMapArea.put("Cylinder", "2πr^2+h(2πr)");
		equationMapArea.put("Cone", "πrl+πr^2");
		// VOLUME
		equationMapVolume.put("Rectangle", "N3D");
		equationMapVolume.put("Circle", "N3D");
		equationMapVolume.put("Oval", "N3D");
		equationMapVolume.put("Box", "w*h*l");
		equationMapVolume.put("Sphere", "4/3*πr^3");
		equationMapVolume.put("Cylinder", "πr^2h");
		equationMapVolume.put("Cone", "1/3*πr^2h");
		// circumferenceE
		equationMapCircumference.put("Rectangle", "2*(h+w)");
		equationMapCircumference.put("Circle", "2πr");
		equationMapCircumference.put("Oval", "~2π√((a^2+b^2)/2)");
		equationMapCircumference.put("Box", "N2D");
		equationMapCircumference.put("Sphere", "N2D");
		equationMapCircumference.put("Cylinder", "N2D");
		equationMapCircumference.put("Cone", "N2D");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		int keycode = e.getKeyCode();
		if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (keycode == 8)
				|| (c == KeyEvent.VK_PERIOD) || (c == KeyEvent.VK_DECIMAL))) {
			Toolkit.getDefaultToolkit().beep();
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		updateOutput();
	}

}
