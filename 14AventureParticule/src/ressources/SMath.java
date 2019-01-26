/**
 * 
 */
package ressources;

import java.util.Arrays;

import ressources.SNoImplementationException;
import ressources.SRuntimeException;

/**
 * La classe <b>SMath</b> contient des m�thodes de calcul qui sont
 * compl�mentaire � la classe java.lang.Math. Elle perment entre autre d'�valuer
 * les racines r�elles d'un polyn�me de degr� 1, 2, 3 et 4.
 * 
 * @author Simon V�zina
 * @since 2015-02-19
 * @version 2017-12-20 (version labo � Le ray tracer v2.1)
 */
public final class SMath {

	/**
	 * La constante <b>NO_ROOT_SOLUTION</b> repr�sente le tableau des solutions au
	 * racine d'un polyn�me o� il n'y a <u>pas de solution r�elle</u>. Le tableau
	 * est donc vide et de taille �gale � z�ro.
	 */
	public static double[] NO_ROOT_SOLUTION = new double[0];

	/**
	 * <p>
	 * La constante <b>EPSILON</b> repr�sentante un nombre tr�s petit, mais non nul.
	 * Ce chiffre peut �tre utilis� pour comparer une valeur de type double avec le
	 * chiffre z�ro. Puisqu'un double �gale � z�ro est difficile � obtenir
	 * num�riquement apr�s un calcul (sauf si l'on multiplie par z�ro), il est
	 * pr�f�rable de comparer un "pseudo z�ro" avec cette constante.
	 * </p>
	 * <p>
	 * Avec une valeur de EPSILON = 1e-10, cette valeur permet de comparer
	 * ad�quatement des nombres autour de '1' avec suffisamment de chiffres
	 * significatifs.
	 * </p>
	 */
	public static double EPSILON = 1e-10;

	/**
	 * La constante <b>EPSILON_RELAXED</b> repr�sente un nombre tr�s petit, mais
	 * mille fois plus grand que EPSILON (1000*EPSILON). Pour des raisons
	 * num�riques, le seuil EPSILON est trop petit et ce nouveau seuil peut �tre
	 * ad�quat.
	 */
	public static double EPSILON_RELAXED = EPSILON * 1000.0;

	/**
	 * La constante <b>NEGATIVE_EPSILON</b> repr�sentante un nombre tr�s petit, mais
	 * non nul qui est <b>negatif</b>. Ce chiffre peut �tre utilis� pour comparer
	 * une valeur arbiraire de type double avec le chiffre z�ro, mais qui sera
	 * n�gatif. Puisqu'un double �gale � z�ro est difficile � obtenir num�riquement
	 * apr�s un calcul (sauf si l'on multiplie par z�ro), il est pr�f�rable de
	 * comparer un "pseudo z�ro" avec cette constante.
	 */
	public static double NEGATIVE_EPSILON = -1.0 * EPSILON;

	/**
	 * La constante <b>ONE_PLUS_EPSILON</b> repr�sente une constante �gale � <b>1 +
	 * EPSILON</b> ce qui correspond � un nombre l�g�rement sup�rieur � 1.
	 */
	public static double ONE_PLUS_EPSILON = 1 + EPSILON;

	/**
	 * La constante <b>ONE_MINUS_EPSILON</b> repr�sente une constant �gale � <b>1 -
	 * EPSILON</b> ce qui correspond � un nombre l�g�rement inf�rieur � 1.
	 */
	public static double ONE_MINUS_EPSILON = 1 - EPSILON;

	/**
	 * La constante <b>ONE_PLUS_1000EPSILON</b> repr�sente une constante �gale �
	 * <b>1 + 1000*EPSILON</b> ce qui correspond � un nombre l�g�rement sup�rieur �
	 * 1.
	 */
	public static double ONE_PLUS_1000EPSILON = 1 + 1000 * EPSILON;

	/**
	 * La constante <b>ONE_MINUS_EPSILON</b> repr�sente une constant �gale � <b>1 -
	 * 1000*EPSILON</b> ce qui correspond � un nombre l�g�rement inf�rieur � 1.
	 */
	public static double ONE_MINUS_1000EPSILON = 1 - 1000 * EPSILON;

	/**
	 * La constante <b>INFINITY</b> repr�sente un nombre positif �gale � l'infini.
	 * Cette valeur est obtenue � partir de la classe java.lang.Double.
	 * 
	 * @see java.lang.Double
	 */
	public static double INFINITY = Double.POSITIVE_INFINITY;

	/**
	 * M�thode pour d�terminer si deux nombres de type double sont <b>relativement
	 * �gaux</b>. En utilisant une approche de calcul de diff�rence, on v�rifie si
	 * <ul>
	 * a - b < EPSILON*ref
	 * </ul>
	 * afin de <b>valid� l'�galit�</b> entre a et b (a == b). EPSILON est un seuil
	 * de pr�cision et ref est une base de r�f�rence (la valeur absolue la plus
	 * �lev�e parmis a et b).
	 * <p>
	 * Cependant, si les deux chiffres sont inf�rieurs � EPSILON, ils seront
	 * consid�r�s comme �gaux.
	 * </p>
	 * 
	 * @param a
	 *            Le 1ier nombre � comparer.
	 * @param b
	 *            Le 2i�me nombre � comparer.
	 * @return <b>true</b> si les deux nombres sont <b>relativement �gaux</b> et
	 *         <b>false</b> sinon.
	 */
	public static boolean nearlyEquals(double a, double b) {
		return nearlyEquals(a, b, EPSILON);
	}

	/**
	 * M�thode pour d�terminer si deux nombres de type double sont <b>relativement
	 * �gaux</b>. En utilisant une approche de calcul de diff�rence, on v�rifie si
	 * <ul>
	 * a - b < EPSILON*ref
	 * </ul>
	 * afin de <b>valid� l'�galit�</b> entre a et b (a == b). EPSILON est un seuil
	 * de pr�cision et ref est une base de r�f�rence (la valeur absolue la plus
	 * �lev�e parmis a et b).
	 * <p>
	 * Cenpendant, si les deux chiffres sont inf�rieurs � EPSILON, ils seront
	 * consid�r�s comme �gaux.
	 * </p>
	 * 
	 * @param a
	 *            Le 1ier nombre � comparer.
	 * @param b
	 *            Le 2i�me nombre � comparer.
	 * @param epsilon
	 *            - La pr�cision acceptable.
	 * @return <b>true</b> si les deux nombres sont <b>relativement �gaux</b> et
	 *         <b>false</b> sinon.
	 */
	public static boolean nearlyEquals(double a, double b, double epsilon) {
		double absA = Math.abs(a);
		double absB = Math.abs(b);
		double diff = Math.abs(a - b);

		// V�rification du cas particulier : 0 = 0 et infiny = infiny (mais pas certain
		// ...)
		if (a == b)
			return true;

		// Cas des petites chiffres : V�rifier si les deux chiffres sont tr�s pr�s l'un
		// de l'autre
		if (diff < epsilon)
			return true;

		// Cas g�n�ral
		double positive_max;

		if (absA > absB)
			positive_max = absA;
		else
			positive_max = absB;

		if (diff < positive_max * epsilon)
			return true;
		else
			return false;
	}

	/**
	 * M�thpde pour d�terminer si une valeur est relativement pr�s de z�ro. Cette
	 * m�thode est n�cessaire, car une op�ration math�matique menant au chiffre 0
	 * peut �tre 0.0 et -0.0 ce qui n'est pas �gal selon JAVA.
	 * 
	 * @param value
	 *            La valeur � comparer avec 0.
	 * @return <b>true</b> si la valeur est <b>relativement �gal</b> � z�ro et
	 *         <b>false</b> sinon.
	 */
	public static boolean nearlyZero(double value) {
		return nearlyEquals(value, 0.0);
	}

	/**
	 * M�thode pour d�terminer si deux tableau de nombres de type double sont
	 * <b>relativement �gaux</b>. En utilisant une approche de calcul de diff�rence,
	 * on v�rifie si pour chaque �l�ment du tableau
	 * <ul>
	 * a - b < EPSILON*ref
	 * </ul>
	 * afin de <b>valid� l'�galit�</b> entre a et b (a == b). EPSILON est un seuil
	 * de pr�cision et ref est une base de r�f�rence (la valeur absolue la plus
	 * �lev�e parmis a et b).
	 * <p>
	 * Cenpendant, si les deux chiffres sont inf�rieurs � EPSILON, ils seront
	 * consid�r�s comme �gaux.
	 * </p>
	 * 
	 * @param tab1
	 *            Le premier tableau � comparer.
	 * @param tab2
	 *            Le deuxi�me tableau � comparer.
	 * @param epsilon
	 *            La pr�cision acceptable.
	 * @return <b>true</b> si les deux tableaux sont <b>relativement �gaux</b> et
	 *         <b>false</b> sinon.
	 */
	public static boolean nearlyEquals(double[] tab1, double[] tab2, double epsilon) {
		// V�rifier que les deux tableaux ont la m�me taille.
		if (tab1.length != tab2.length)
			return false;

		// V�rifier que l'ensemble des donn�e indexe par indexe sont "nearlyEquals".
		for (int i = 0; i < tab1.length; i++)
			if (!nearlyEquals(tab1[i], tab2[i], epsilon))
				return false;

		// Puisque l'ensemble des valeurs indexe par indexe sont "nearlyEquals", le
		// tableau doit l'�tre.
		return true;
	}

	/**
	 * M�thode permettant d'�valuer la racine r�elle d'un polyn�me de degr� '1' de
	 * la forme
	 * <ul>
	 * Ax + B = 0.
	 * </ul>
	 * <p>
	 * Un polyn�me de degr� '1' poss�de au maximum <b>une</b> racine r�elle.
	 * </p>
	 * 
	 * @param A
	 *            Le coefficient devant le terme de puissance '1' (x).
	 * @param B
	 *            Le coefficient devant le terme de puissance '0' (1).
	 * @return La racine r�elle d'un polyn�me de degr� '1' (s'il y en a).
	 * @throws SInfinityOfSolutionsException
	 *             Si le polyn�me contient une infinit� de solution (0x + 0 = 0).
	 */
	public static double[] linearRealRoot(double A, double B) throws SInfinityOfSolutionsException {
		// V�rifier si le polyn�me n'est pas d'un degr� inf�rieur.
		if (nearlyZero(A)) {
			// V�rifier si l'�quation n'est pas 0*t + B = 0.
			// Si B == 0, l'�quation admettra une infinit� de solutions.
			// Autrement, l'�quation n'admettra aucune solution.
			if (nearlyZero(B))
				throw new SInfinityOfSolutionsException(
						"L'�quation lin�aire 0x + 0 = 0 admet une infinit� de solutions.");
			else
				return NO_ROOT_SOLUTION;
		}
		double result[] = new double[1];
		result[0] = -B / A;
		return result;

	}

	/**
	 * M�thode permettant d'�valuer les racines r�elles d'un polyn�me de degr� '2'
	 * de la forme
	 * <ul>
	 * Ax^2 + Bx + C = 0.
	 * </ul>
	 * <p>
	 * Un polyn�me de degr� '2' poss�de au maximum <b>deux</b> racines r�elles.
	 * </p>
	 * 
	 * @param A
	 *            Le coefficient devant le terme de puissance '2' (x^2).
	 * @param B
	 *            Le coefficient devant le terme de puissance '1' (x).
	 * @param C
	 *            Le coefficient devant le terme de puissance '0' (1).
	 * @return Les racines r�elles de d'un polyn�me de degr� '2' (s'il y en a). Les
	 *         solutions retourn�es dans un tableau sont <b>tri�es en ordre
	 *         croissant</b>.
	 * @throws SInfinityOfSolutionsException
	 *             Si le polyn�me contient une infinit� de solution (0x^2 + 0x + 0 =
	 *             0).
	 */
	public static double[] quadricRealRoot(double A, double B, double C) throws SInfinityOfSolutionsException {
		// V�rifier si le polyn�me n'est pas d'un degr� inf�rieur
		if (nearlyZero(A))
			return linearRealRoot(B, C);

		double[] result;
		double delta = Math.pow(B, 2) - 4 * A * C;
		if (delta < 0) {
			result = new double[0];
		} else if (delta == 0) {
			result = new double[1];
			result[0] = -B / (2 * A);
		} else {
			double result1 = (-B + Math.sqrt(delta)) / (2 * A);
			double result2 = (-B - Math.sqrt(delta)) / (2 * A);
			result = new double[2];
			result[0] = (result1 < result2) ? result1 : result2;
			result[1] = (result1 < result2) ? result2 : result1;
		}
		return result;
	}

	/**
	 * M�thode permettant d'�valuer les racines r�elles d'un polyn�me de degr� '3'
	 * de la forme
	 * <ul>
	 * Ax^3 + Bx^2 + Cx + D = 0.
	 * </ul>
	 * <p>
	 * Un polyn�me de degr� '3' poss�de au maximum <b>trois</b> racines r�elles.
	 * </p>
	 * 
	 * @param A
	 *            Le coefficient devant le terme de puissance '3' (x^3).
	 * @param B
	 *            Le coefficient devant le terme de puissance '2' (x^2).
	 * @param C
	 *            Le coefficient devant le terme de puissance '1' (x).
	 * @param D
	 *            Le coefficient devant le terme de puissance '0' (1).
	 * @return Les racines r�elles de d'un polyn�me de degr� '3' (s'il y en a). Les
	 *         solutions retourn�es dans un tableau sont <b>tri�es en ordre
	 *         croissant</b>.
	 * @throws SInfinityOfSolutionsException
	 *             Si le polyn�me contient une infinit� de solution (0x^3 + 0x^2 +
	 *             0x + 0 = 0).
	 */
	public static double[] cubicRealRoot(double A, double B, double C, double D) throws SInfinityOfSolutionsException {
		// V�rifier si le polyn�me n'est pas d'un degr� inf�rieur
		if (nearlyZero(A))
			return quadricRealRoot(B, C, D);

		throw new SNoImplementationException("Erreur SMath : C'est m�thode n'a pas �t� impl�ment�e.");
	}

	/**
	 * M�thode permettant d'�valuer les racines r�elles d'un polyn�me de degr� '4'
	 * de la forme
	 * <ul>
	 * Ax^4 + Bx^3 + Cx^2 + Dx + E = 0.
	 * </ul>
	 * <p>
	 * Un polyn�me de degr� '4' poss�de au maximum <b>quatre</b> racines r�elles.
	 * </p>
	 * 
	 * @param A
	 *            Le coefficient devant le terme de puissance '4' (x^4).
	 * @param B
	 *            Le coefficient devant le terme de puissance '3' (x^3).
	 * @param C
	 *            Le coefficient devant le terme de puissance '2' (x^2).
	 * @param D
	 *            Le coefficient devant le terme de puissance '1' (x).
	 * @param E
	 *            Le coefficient devant le terme de puissance '0' (1).
	 * @return Les racines r�elles de d'un polyn�me de degr� '4' (s'il y en a). Les
	 *         solutions retourn�es dans un tableau sont <b>tri�es en ordre
	 *         croissant</b>.
	 * @throws SInfinityOfSolutionsException
	 *             Si le polyn�me contient une infinit� de solution (0x^4 + 0x^3 +
	 *             0x^2 + 0x + 0 = 0).
	 */
	public static double[] quarticRealRoot(double A, double B, double C, double D, double E)
			throws SInfinityOfSolutionsException {
		// V�rifier si le polyn�me n'est pas d'un degr� inf�rieur.
		if (nearlyZero(A))
			return cubicRealRoot(B, C, D, E);

		throw new SNoImplementationException("Erreur SMath : C'est m�thode n'a pas �t� impl�ment�e.");
	}

	/**
	 * M�thode qui effectue le calcul inverse de l'interpolation lin�aire d'une
	 * valeur num�rique. Cela sigifie que l'on cherche la valeur du param�tre
	 * d'interpolation t � partir d'une valeur interpol�e ainsi que des deux valeurs
	 * extr�mes.
	 * 
	 * @param v
	 *            La valeur interpol�e dont la valeur de t doit �tre calcul�e.
	 * @param v0
	 *            La valeur de r�f�rence pond�r�e par 1 - t.
	 * @param v1
	 *            La valeur de r�f�rence pond�r�e par le facteur t.
	 * @return La facteur t d'interpolation lin�aire.
	 */
	public static double reverseLinearInterpolation(double v, double v0, double v1) {
		// � partir de la relation v = (1-t)*v0 + t*v1 , on doit isoler t.
		return (v - v0) / (v1 - v0);
	}

	/**
	 * M�thode qui effectue le calcul de l'interpolation lin�aire d'une valeur
	 * num�rique.
	 * 
	 * @param v0
	 *            La valeur de r�f�rence pond�r�e par 1 - t.
	 * @param v1
	 *            La valeur de r�f�rence pond�r�e par le facteur t.
	 * @param t
	 *            Le param�tre de pond�ration.
	 * @return La valeur interpol�e.
	 * @throws SRuntimeException
	 *             Si la contrainte sur t n'est pas respect�e (0 <= t <= 1).
	 */
	public static double linearInterpolation(double v0, double v1, double t) throws SRuntimeException {
		// Doit satisfaire la contrainte sur t
		if (t < 0.0 || t > 1.0)
			throw new SRuntimeException(
					"Erreur SMath 002 : Le param�tre d'interpolation t = " + t + " n'est pas compris entre 0 et 1.");

		// Calcul de l'interpolation : v = v0*(1 - t) + v1*t
		return v0 * (1.0 - t) + (v1 * t);
	}

	/**
	 * M�thode qui effectue le calcul de l'interpolation quadratique d'une valeur
	 * num�rique.
	 * 
	 * @param v0
	 *            La valeur de r�f�rence pond�r�e par 1 - t*t.
	 * @param v1
	 *            La valeur de r�f�rence pond�r�e par le facteur t*t.
	 * @param t
	 *            Le param�tre de pond�ration.
	 * @return La valeur interpol�e.
	 * @throws SRuntimeException
	 *             Si la contrainte sur t n'est pas respect�e (0 <= t <= 1).
	 */
	public static double quadricInterpolation(double v0, double v1, double t) throws SRuntimeException {
		// Doit satisfaire la contrainte sur t
		if (t < 0.0 || t > 1.0)
			throw new SRuntimeException(
					"Erreur SMath 003 : Le param�tre d'interpolation t = " + t + " n'est pas compris entre 0 et 1.");

		// Calcul de l'interpolation : v = v0*(1 - t^2) + v1*t^2
		double t2 = t * t;

		return v0 * (1.0 - t2) + v1 * t2;
	}

	/**
	 * ...
	 * 
	 * @param array
	 * @return
	 */
	public static double strategicArraySum(double[] array) {
		// STRAT�GIE DE SOMMATION : Trier en valeur absolue les nombres et en faire
		// l'addition.

		// Faire une copie des donn�es dans un tableau de type objet Double.
		Double[] tab = new Double[array.length];

		for (int i = 0; i < array.length; i++)
			tab[i] = new Double(array[i]);

		// Faire le trie des donn�es avec le comparateur en valeur absolue.
		Arrays.sort(tab, new SAbsoluteDoubleComparator());

		// Faire la somme des termes du tableau dans l'ordre strat�gique qui devrait
		// minimiser l'impr�cision.
		double value = 0.0;

		for (Double d : tab)
			value += d.doubleValue();

		return value;

	}

	/**
	 * M�thode d�terminant le signe d'un nombre. Les r�sultats sont
	 * <ul>
	 * -1 si a < 0
	 * </ul>
	 * <ul>
	 * 0 si a = 0
	 * </ul>
	 * <ul>
	 * 1 si a > 0
	 * </ul>
	 * 
	 * @param a
	 *            Le nombre.
	 * @return Le signe du nombre.
	 */
	public static double sgn(double a) {
		if (a > 0)
			return 1.0;
		else if (a < 0)
			return -1.0;
		else
			return 0.0;
	}

	/**
	 * M�thode pour obtenir la <b>plus grande valeur</b> d'un tableau.
	 * 
	 * @param tab
	 *            Le tableau.
	 * @return La plus grande valeur du tableau.
	 */
	public static int findMax(int[] tab) {
		int max = tab[0];

		for (int v : tab)
			if (v > max)
				max = v;

		return max;
	}

	/**
	 * M�thode pour obtenir la <b>plus grande valeur</b> d'un tableau.
	 * 
	 * @param tab
	 *            Le tableau.
	 * @return La plus grande valeur du tableau.
	 */
	public static double findMax(double[] tab) {
		double max = tab[0];

		for (double v : tab)
			if (v > max)
				max = v;

		return max;
	}

	/**
	 * M�thode pour obtenir la <b>plus petite valeur</b> d'un tableau.
	 * 
	 * @param tab
	 *            Le tableau.
	 * @return La plus petite valeur du tableau.
	 */
	public static int findMin(int[] tab) {
		int min = tab[0];

		for (int v : tab)
			if (v < min)
				min = v;

		return min;
	}

	/**
	 * M�thode pour obtenir la <b>plus petite valeur</b> d'un tableau.
	 * 
	 * @param tab
	 *            Le tableau.
	 * @return La plus petite valeur du tableau.
	 */
	public static double findMin(double[] tab) {
		double min = tab[0];

		for (double v : tab)
			if (v < min)
				min = v;

		return min;
	}

	public static double findMinValueGreaterThanReference(double[] tab, double reference) {
		for (double nb : tab) {
			if (nb > reference) {
				return nb;
			}
		}
		return 0;
	}

	/**
	 * M�thode pour convertir un tableau d'entier vers un tableau de nombre r�el
	 * entre une valeur minimale et maximale. La correspondance entre les valeurs
	 * converties sera lin�aire.
	 * 
	 * @param data
	 *            Les entiers � convertir.
	 * @param min
	 *            La borne minimale.
	 * @param max
	 *            La borne maximale.
	 * @return Le tableau converti.
	 * @throws SRuntimeException
	 *             Si les bornes sont mal d�finies.
	 */
	public static double[] mappingIntToDouble(int[] data, double min, double max) throws SRuntimeException {
		if (min > max)
			throw new SRuntimeException("Erreur SMath 003 : La borne minimale " + min + " et la borne maximale " + max
					+ " sont mal d�finies.");

		int min_value = SMath.findMin(data);
		int max_value = SMath.findMax(data);

		double[] result = new double[data.length];

		// It�rer sur l'ensemble des �l�ments du tableau.
		for (int i = 0; i < result.length; i++) {
			double t = SMath.reverseLinearInterpolation((double) data[i], (double) min_value, (double) max_value);
			result[i] = SMath.linearInterpolation(min, max, t);
		}

		return result;
	}

	/**
	 * M�thode pour convertir un tableau de nombre r�el vers un tableau d'entier
	 * entre une valeur minimale et maximale. La correspondance entre les valeurs
	 * converties sera lin�aire.
	 * 
	 * @param data
	 *            Les donn�es � convertir.
	 * @param min
	 *            La borne minimale.
	 * @param max
	 *            La borne maximale.
	 * @return Le tableau converti.
	 * @throws SRuntimeException
	 *             Si les bornes sont mal d�finies.
	 */
	public static int[] mappingDoubleToInt(double[] data, int min, int max) {
		if (min > max)
			throw new SRuntimeException("Erreur SMath 004 : La borne minimale " + min + " et la borne maximale " + max
					+ " sont mal d�finies.");

		double min_value = SMath.findMin(data);
		double max_value = SMath.findMax(data);

		int[] result = new int[data.length];

		// It�rer sur l'ensemble des �l�ments du tableau.
		for (int i = 0; i < result.length; i++) {
			double t = SMath.reverseLinearInterpolation(data[i], min_value, max_value);
			result[i] = (int) SMath.linearInterpolation(min, max, t);
		}

		return result;
	}

	/**
	 * <p>
	 * M�thode permettant de g�n�rer un tableau contenant les �l�ments identique de
	 * deux tableaux de valeur
	 * <ul>
	 * pr�alablement tri�
	 * </ul>
	 * .
	 * </p>
	 * 
	 * <p>
	 * <b>REMARQUE</b> : Le fonctionnement de cette m�thode ne sera pas valide si
	 * les deux tableaux pass�s en param�tre ne sont pas p�alablement tri�.
	 * </p>
	 * R�f�rence :
	 * https://stackoverflow.com/questions/32676381/find-intersection-of-two-arrays
	 * 
	 * @param tab1
	 *            Le 1ier tableau � comparer.
	 * @param tab2
	 *            Le 2i�me tableau � comparer.
	 * @return Un tableau comprenant les �l�ments identiques de deux tableaux
	 *         (l'intersection des deux tableaux).
	 */
	public static double[] intersectionSortedArray(double[] tab1, double[] tab2) {
		return intersectionSortedArray(tab1, tab2, EPSILON);
	}

	/**
	 * <p>
	 * M�thode permettant de g�n�rer un tableau contenant les �l�ments identique de
	 * deux tableaux de valeur
	 * <ul>
	 * pr�alablement tri�
	 * </ul>
	 * .
	 * </p>
	 * 
	 * <p>
	 * <b>REMARQUE</b> : Le fonctionnement de cette m�thode ne sera pas valide si
	 * les deux tableaux pass�s en param�tre ne sont pas p�alablement tri�.
	 * </p>
	 * R�f�rence :
	 * https://stackoverflow.com/questions/32676381/find-intersection-of-two-arrays
	 * 
	 * @param tab1
	 *            Le 1ier tableau � comparer.
	 * @param tab2
	 *            Le 2i�me tableau � comparer.
	 * @param epsilon
	 *            La pr�cision de la comparaison.
	 * @return Un tableau comprenant les �l�ments identiques de deux tableaux
	 *         (l'intersection des deux tableaux).
	 */
	public static double[] intersectionSortedArray(double[] tab1, double[] tab2, double epsilon) {
		double intersection[] = new double[Math.min(tab1.length, tab2.length)];
		int count = 0;

		int i = 0;
		int j = 0;
		while (i < tab1.length && j < tab2.length) {
			// V�rifier s'il y a �galit�.
			if (SMath.nearlyEquals(tab1[i], tab2[j], epsilon)) {
				intersection[count] = tab1[i];
				count++;
				i++;
				j++;
			} else
			// Avancer dans la recherche des �l�ments.
			if (tab1[i] < tab2[j])
				i++; // avancer dans le tableau 1
			else
				j++; // avancer dans le tableau 2
		}

		// Construire un tableau avec l'espace m�moire minimum.
		double[] result = new double[count];
		for (int k = 0; k < result.length; k++)
			result[k] = intersection[k];

		return result;
	}

}// fin de la classe SMath
