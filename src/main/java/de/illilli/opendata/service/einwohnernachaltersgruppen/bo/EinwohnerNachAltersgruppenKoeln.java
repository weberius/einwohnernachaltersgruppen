package de.illilli.opendata.service.einwohnernachaltersgruppen.bo;

public class EinwohnerNachAltersgruppenKoeln extends EinwohnerNachAltersgruppen {

	private String koelnGesamt;

	public String getKoelnGesamt() {
		return koelnGesamt;
	}

	public void setKoelnGesamt(String koelnGesamt) {
		this.koelnGesamt = koelnGesamt;
	}

	@Override
	public String toString() {
		return "EinwohnerNachAltersgruppenKoeln [koelnGesamt=" + koelnGesamt
				+ ", getEinwohnerInsgesamt()=" + getEinwohnerInsgesamt()
				+ ", getA0_2()=" + getA0_2() + ", getA3_5()=" + getA3_5()
				+ ", getA6_14()=" + getA6_14() + ", getA15_17()=" + getA15_17()
				+ ", getA18_20()=" + getA18_20() + ", getA21_34()="
				+ getA21_34() + ", getA35_59()=" + getA35_59()
				+ ", getA60_64()=" + getA60_64() + ", getA65_74()="
				+ getA65_74() + ", getA75_79()=" + getA75_79()
				+ ", getA80undAelter()=" + getA80undAelter() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((koelnGesamt == null) ? 0 : koelnGesamt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EinwohnerNachAltersgruppenKoeln other = (EinwohnerNachAltersgruppenKoeln) obj;
		if (koelnGesamt == null) {
			if (other.koelnGesamt != null)
				return false;
		} else if (!koelnGesamt.equals(other.koelnGesamt))
			return false;
		return true;
	}

}
