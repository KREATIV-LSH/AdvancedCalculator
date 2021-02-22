package ch.lsh.advancedcalculator.frame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ch.lsh.advancedcalculator.calculator.Calculator;
import ch.lsh.advancedcalculator.calculator.CalculatorManager;

public class FrameSelectCalculator implements ListSelectionListener {

	private static JFrame frame;
	private JPanel panel;
	

	private JList<String> list;

	public FrameSelectCalculator() {
		frame = new JFrame("Select Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(calculateWidth() + (3 * 20), calculateHeight() + 60);
		frame.setResizable(false);
		panel = new JPanel();
		panel.setLayout(null);

		list = new JList<String>(CalculatorManager.getCaclulatorNames());
		list.setSize(calculateWidth(), calculateHeight());
		list.setLocation(20, 5);
		list.setBackground(Color.BLACK);
		list.setForeground(new Color(214, 237, 23));
		list.setSelectionBackground(new Color(214, 237, 23));
		list.setSelectionForeground(Color.BLACK);
		list.addListSelectionListener(this);
//		list.setSelectedValue(CalculatorManager.getCaclulatorNames()[0], false);
		panel.add(list);
		
		panel.setBackground(new Color(96, 96, 96));
		
		frame.add(panel);
		frame.setVisible(true);
	}

	private static int calculateWidth() {
		int temp = Integer.MIN_VALUE;
		for (Calculator calc : CalculatorManager.getCalculatorList()) {
			temp = Math.max(temp, calc.getCalculator().stripLeading().length());
		}
		return temp * 7;
	}

	private static int calculateHeight() {
		return CalculatorManager.getCaclulatorNames().length * 20;
	}

	@Override
	public void valueChanged(ListSelectionEvent ae) {
		if (ae.getSource() == list) {
				Calculator calc = CalculatorManager.getCalculatorByName((String) list.getSelectedValue());
				if(calc == null)
					return;
//				frame.setSize(calculateWidth() + (3 * 20) + calc.getWidth(), calculateHeight() + calc.getHeight());
//				if (calculatorPanel != null) {
//					frame.remove(calculatorPanel);
//				}
//				calculatorPanel = calc.execute(frame);
//				calculatorPanel.setSize(calc.getWidth(), calc.getHeight());
//				calculatorPanel.setLocation(calculateWidth() + (3 * 20), 0);
//				frame.add(calculatorPanel);
				JFrame calculatorFrame = calc.execute();
				calculatorFrame.setVisible(true);
				try {
					list.clearSelection();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

}
