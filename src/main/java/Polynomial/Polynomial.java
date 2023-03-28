package Polynomial;

import java.util.Collections;
import java.util.HashMap;



	public class Polynomial {

		//public static final String polinom1 = null;
		private HashMap<Integer, Double> polynomial;

		public Polynomial(HashMap<Integer, Double> polynomial) {
			super();
			this.polynomial = polynomial;
		}

		public HashMap<Integer, Double> addPolynomials(Polynomial pol) {
			HashMap<Integer, Double> rezultat = new HashMap<Integer, Double>();

			for (int key : this.polynomial.keySet()) {
				double addition = this.polynomial.get(key) + pol.polynomial.getOrDefault(key, 0.0);

				rezultat.put(key, addition);

			}

			for (int key : pol.polynomial.keySet()) {

				if (this.polynomial.containsKey(key) == false && pol.polynomial.containsKey(key) == true) {

					double addition = pol.polynomial.get(key);
					rezultat.put(key, addition);
				}

			}

			return rezultat;

		}


		public HashMap<Integer, Double> subPolynomials(Polynomial pol) {
			HashMap<Integer, Double> rezultat = new HashMap<Integer, Double>();

			for (int key : this.polynomial.keySet()) {
				double diff = this.polynomial.get(key) - pol.polynomial.getOrDefault(key, 0.0);

				rezultat.put(key, diff);

			}

			for (int key : pol.polynomial.keySet()) {

				if (this.polynomial.containsKey(key) == false && pol.polynomial.containsKey(key) == true) {

					double diff = -pol.polynomial.get(key);
					rezultat.put(key, diff);
				}

			}

			return rezultat;

		}

		public HashMap<Integer, Double> multiplyPolynomials(Polynomial pol) {
			HashMap<Integer, Double> rezultat = new HashMap<Integer, Double>();

			for (int keyPol1 : this.polynomial.keySet()) {
				for (int keyPol2 : pol.polynomial.keySet()) {
					int keyRez = keyPol1 + keyPol2;
					double coef = this.polynomial.get(keyPol1) * pol.polynomial.get(keyPol2);
					if (rezultat.containsKey(keyRez) == false) {
						// verificam daca in polinom rezultat s-a obtinut deja un termen cu coeficientul
						// x^4 de exemplu
						rezultat.put(keyRez, coef);

					} else {
						rezultat.put(keyRez, rezultat.get(keyRez) + coef);
					}

				}

			}

			return rezultat;

		}
		
		public HashMap<Integer, Double> dividePolynomials(Polynomial pol) {
			HashMap<Integer, Double> rezultat = new HashMap<Integer, Double>();

			int gradPol1 = Collections.max(this.polynomial.keySet());
			int gradPol2 = Collections.max(pol.polynomial.keySet());

			while (gradPol1 >=gradPol2) {
				double coeficient = this.polynomial.get(gradPol1) / pol.polynomial.get(gradPol2);
				rezultat.put(gradPol1 - gradPol2, coeficient);
				for (int i = gradPol2; i >= 0; i--) {

					double coefDeimpartit = this.polynomial.getOrDefault(gradPol1 - (gradPol2 - i), 0.0);
					double coefImpartitor = pol.polynomial.getOrDefault(i, 0.0);

					this.polynomial.put(gradPol1 - (gradPol2 - i), coefDeimpartit - (coefImpartitor * coeficient));

				}
				this.polynomial.remove(gradPol1);
				gradPol1=Collections.max(this.polynomial.keySet());

			}

			return rezultat;

		}

		public HashMap<Integer, Double> derivativePolynomials() {
			HashMap<Integer, Double> rezultat = new HashMap<Integer, Double>();

			for (int key : this.polynomial.keySet()) {
				double coeficient = this.polynomial.get(key);
				double coeficientDerivare = coeficient * key;
				int gradDerivare = key - 1;

				if (coeficientDerivare != 0) {
					rezultat.put(gradDerivare, coeficientDerivare);
				}
			}

			return rezultat;

		}
		
		public HashMap<Integer, Double> IntegralPolynomials() {
			HashMap<Integer, Double> rezultat = new HashMap<Integer, Double>();

			for (int key : this.polynomial.keySet()) {
				double coeficient = this.polynomial.get(key);
				double coeficientIntegrare = coeficient/(key+1);
				int gradIntegrare = key + 1;

				if (coeficientIntegrare != 0) {
					rezultat.put(gradIntegrare, coeficientIntegrare);
				}
			}

			return rezultat;

		}
		

		
		
		public String toString() {
			String str = "";
			for (int key:this.polynomial.keySet()) {
				int grad = key;
				double coefficient = this.polynomial.get(key);
				if (coefficient != 0) {
					if (coefficient > 0 ) {
						str += "+";
					}

					if (coefficient == 1) {
						if (grad == 0) {
							str += "1";
						} else if (grad == 1) {
							str += "x";
						} else {
							str += "x^" + grad;
						}
					} else if (coefficient == -1) {
						if (grad == 0) {
							str += "-1";
						} else if (grad == 1) {
							str += "-x";
						} else {
							str += "-x^" + grad;
						}
					} else {
						if (grad == 0) {
							str += coefficient;
						} else if (grad == 1) {
							str += coefficient + "x";
						} else {
							str += coefficient + "x^" + grad;
						}
					}
				}
			}

		

			return str;
		}

	
	}
