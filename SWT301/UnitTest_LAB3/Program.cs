public class PersonalIncomeTaxCalculator
{
    public float fncPersonalIncomeTax(float sal, float te, int nod)
    {
        if (sal < 0 || te < 0 || nod < 0)
        {
            return -1;
        }

        float ti = sal - te - 9_000_000 - nod * 4_000_000;

        if (ti <= 0)
        {
            return 0;
        }
        if (ti <= 5_000_000)
        {
            return 0.05f * ti;
        }
        if (ti <= 10_000_000)
        {
            return 0.10f * ti - 250_000;
        }
        if (ti <= 20_000_000)
        {
            return 0.15f * ti - 750_000;
        }
        if (ti <= 40_000_000)
        {
            return 0.20f * ti - 2_250_000;
        }
        if (ti <= 80_000_000)
        {
            return 0.25f * ti - 6_250_000;
        }
        return 0.30f * ti - 16_250_000;
    }
}
