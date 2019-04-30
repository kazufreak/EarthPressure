package EathPresure;

import java.util.Map;

public class EathPresureCalc {
	//形状寸法
	double H;//擁壁高
	double B;//底版幅
	double bt;//つま先長
	double ta;//先端厚
	double tb;//付け根厚
	double bo;//上端厚
	double bu;//下端厚
	double aN;//前面勾配
	double Lw;//ブロック長

	//盛土
	double H0;//嵩上げ高さ
	double mN;//盛土勾配
	double r0;//土の単位体積重量
	double phi0;//土の内部摩擦角
	double c0;//粘着力

	//載荷重
	double q;//載荷重ｋN/m2
	//設計水平震度
	double kh;
	//根入れ地盤
	double Df;//根入れ深さ
	double r1;//土の単位体積重量
	double phi1;//土の内部摩擦角
	double c1;//粘着力
	//使用材料、許容応力度
	double rc;//co単位体積重量
	double shig_ck;//設計基準強度
	double shig_ca;//許容曲げ圧縮応力度
	double shig_tau_ca;//許容せん断応力度
	double As;//鉄筋の種類
	double shig_s;//許容引張応力度

	public void EathPresureCalc(Map<String,Double> data) {
		//コンストラクタ
		/*リスト形式で諸元を受け取る*/
		this.H = data.get("H");
		this.B = data.get("B");
		this.bt = data.get("bt");
		this.ta = data.get("ta");
		this.tb = data.get("tb");
		this.bo = data.get("bo");
		this.bu = data.get("bu");
		this.aN = data.get("aN");
		this.Lw = data.get("Lw");

		//盛土
		this.H0 = data.get("H0");
		this.mN = data.get("mN");
		this.r0 = data.get("r0");
		this.phi0 = data.get("phi0");
		this.c0 = data.get("c0");

		//載荷重
		this.q = data.get("q");
		//設計水平震度
		this.kh = data.get("kh");
		//根入れ地盤
		this.Df = data.get("Df");
		this.r1 = data.get("r1");
		this.phi1 = data.get("phi1");
		this.c1 = data.get("c1");
		//使用材料、許容応力度
		this.rc = data.get("rc");
		this.shig_ck = data.get("shig_ck");
		this.shig_ca = data.get("shig_ca");
		this.shig_tau_ca = data.get("shig_tau_ca");
		this.As = data.get("As");
		this.shig_s = data.get("shig_s");
	}
	public double[][] co_weight(){
		//自重計算格納配列
		double[][] weight = new double[12][8];
		double Hw = this.H - this.tb;

		weight[0][0] = Hw * this.aN;
		weight[0][1] = Hw;
		weight[0][2] = 1/2 * weight[0][0] * Hw;
		weight[0][3] = this.rc * weight[0][2];
		weight[0][4] = this.bt + weight[0][0] / 3 * 2;
		weight[0][5] = this.tb + Hw / 3;
		weight[0][6] = weight[0][3] * weight[0][4];
		weight[0][7] = weight[0][3] * weight[0][5];


		return weight;
	}


}
