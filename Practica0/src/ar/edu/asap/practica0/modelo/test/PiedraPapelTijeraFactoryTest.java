package ar.edu.asap.practica0.modelo.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.asap.practica0.modelo.Lagartija;
import ar.edu.asap.practica0.modelo.Papel;
import ar.edu.asap.practica0.modelo.Piedra;
import ar.edu.asap.practica0.modelo.PiedraPapelTijeraFactory;
import ar.edu.asap.practica0.modelo.Spock;
import ar.edu.asap.practica0.modelo.Tijera;

class PiedraPapelTijeraFactoryTest {

	Piedra piedra;
	Papel papel;
	Tijera tijera;
	Spock spock;
	Lagartija lagartija;
	
	
	@BeforeEach
	void setUp() throws Exception {
		piedra = new Piedra();
		papel = new Papel();
		tijera = new Tijera();
		spock = new Spock();
		lagartija = new Lagartija();
	}

	@AfterEach
	void tearDown() throws Exception {
		piedra = null;
		papel = null;
		tijera = null;
		spock = null;
		lagartija = null;
	}


	@Test 
	void testPiedraGanaATijera(){
		assertEquals(1, piedra.comparar(tijera));
	}
	@Test
	void testPiedraGanaATijera_comparar_DescripcionResultado() {
		int result=piedra.comparar(tijera);
		assertEquals("piedra le gana a tijera", piedra.getDescriptionResultado());
	}
	
	@Test 
	void testPiedraGanaALagartija(){
		assertEquals(1, piedra.comparar(lagartija));
	}
	@Test
	void testPiedraGanaALagartija_comparar_DescripcionResultado() {
		int result=piedra.comparar(lagartija);
		assertEquals("piedra le gana a lagartija", piedra.getDescriptionResultado());
	}
	
	@Test 
	void testPiedraPierdeConPapel(){
		assertEquals(-1, piedra.comparar(papel));
	}
	@Test
	void testPiedraPierdeConPapel_comparar_DescripcionResultado() {
		int result=piedra.comparar(papel);
		assertEquals("piedra pierde con papel", piedra.getDescriptionResultado());
	}
	
	@Test 
	void testPiedraPierdeConSpock(){
		assertEquals(-1, piedra.comparar(spock));
	}
	@Test
	void testPiedraPierdeConSpock_comparar_DescripcionResultado() {
		int result=piedra.comparar(spock);
		assertEquals("piedra pierde con spock", piedra.getDescriptionResultado());
	}
	
	@Test 
	void testPiedraEmpataConPiedra(){
		assertEquals(0, piedra.comparar(piedra));
	}
	@Test
	void testPiedraEmpataConPiedra_comparar_DescripcionResultado() {
		int result=piedra.comparar(piedra);
		assertEquals("piedra empata con piedra", piedra.getDescriptionResultado());
	}
	
	@Test
	void testGetInstancePiedra() {
		assertEquals("piedra", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.PIEDRA)
								.getNombre());
	}
	
	
	
	
	@Test 
	void testPapelGanaAPiedra(){
		assertEquals(1, papel.comparar(piedra));
	}
	@Test
	void testPapelGanaAPiedra_comparar_DescripcionResultado() {
		int result=papel.comparar(piedra);
		assertEquals("papel le gana a piedra", papel.getDescriptionResultado());
	}
	
	@Test 
	void testPapelGanaASpock(){
		assertEquals(1, papel.comparar(spock));
	}
	@Test
	void testPapelGanaASpock_comparar_DescripcionResultado() {
		int result=papel.comparar(spock);
		assertEquals("papel le gana a spock", papel.getDescriptionResultado());
	}
	
	@Test 
	void testPapelPierdeConTijera(){
		assertEquals(-1, papel.comparar(tijera));
	}
	@Test
	void testPapelPierdeConTijera_comparar_DescripcionResultado() {
		int result=papel.comparar(tijera);
		assertEquals("papel pierde con tijera", papel.getDescriptionResultado());
	}
	
	@Test 
	void testPapelPierdeConLagartija(){
		assertEquals(-1, papel.comparar(lagartija));
	}
	@Test
	void testPapelPierdeConLagartija_comparar_DescripcionResultado() {
		int result=papel.comparar(lagartija);
		assertEquals("papel pierde con lagartija", papel.getDescriptionResultado());
	}
	
	@Test 
	void testPapelEmpataConPapel(){
		assertEquals(0, papel.comparar(papel));
	}
	@Test
	void testPapelEmpataConPapel_comparar_DescripcionResultado() {
		int result=papel.comparar(papel);
		assertEquals("papel empata con papel", papel.getDescriptionResultado());
	}
	
	@Test
	void testGetInstancePapel() {
		assertEquals("papel", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.PAPEL)
								.getNombre());
	}
	
	
	
	@Test 
	void testTijeraGanaAPapel(){
		assertEquals(1, tijera.comparar(papel));
	}
	@Test
	void testTijeraGanaAPapel_comparar_DescripcionResultado() {
		int result=tijera.comparar(papel);
		assertEquals("tijera le gana a papel", tijera.getDescriptionResultado());
	}
	
	@Test 
	void testTijeraGanaALagartija(){
		assertEquals(1, tijera.comparar(lagartija));
	}
	@Test
	void testTijeraGanaALagartija_comparar_DescripcionResultado() {
		int result=tijera.comparar(lagartija);
		assertEquals("tijera le gana a lagartija", tijera.getDescriptionResultado());
	}
	
	@Test 
	void testTijeraPierdeConPiedra(){
		assertEquals(-1, tijera.comparar(piedra));
	}
	@Test
	void testTijeraPierdeConPiedra_comparar_DescripcionResultado() {
		int result=tijera.comparar(piedra);
		assertEquals("tijera pierde con piedra", tijera.getDescriptionResultado());
	}
	
	@Test 
	void testTijeraPierdeConSpock(){
		assertEquals(-1, tijera.comparar(spock));
	}
	@Test
	void testTijeraPierdeConSpock_comparar_DescripcionResultado() {
		int result=tijera.comparar(spock);
		assertEquals("tijera pierde con spock", tijera.getDescriptionResultado());
	}
	
	@Test 
	void testTijeraEmpataConTijera(){
		assertEquals(0, tijera.comparar(tijera));
	}
	@Test
	void testTijeraEmpataConTijera_comparar_DescripcionResultado() {
		int result=tijera.comparar(tijera);
		assertEquals("tijera empata con tijera", tijera.getDescriptionResultado());
	}
	
	@Test
	void testGetInstanceTijera() {
		assertEquals("tijera", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.TIJERA)
								.getNombre());
	}
	
	
	
	@Test 
	void testSpockGanaAPiedra(){
		assertEquals(1, spock.comparar(piedra));
	}
	@Test
	void testSpockGanaAPiedra_comparar_DescripcionResultado() {
		int result=spock.comparar(piedra);
		assertEquals("spock le gana a piedra", spock.getDescriptionResultado());
	}
	
	@Test 
	void testSpockGanaATijera(){
		assertEquals(1, spock.comparar(tijera));
	}
	@Test
	void testSpockGanaATijera_comparar_DescripcionResultado() {
		int result=spock.comparar(tijera);
		assertEquals("spock le gana a tijera", spock.getDescriptionResultado());
	}
	
	@Test 
	void testSpockPierdeConPapel(){
		assertEquals(-1, spock.comparar(papel));
	}
	@Test
	void testSpockPierdeConPapel_comparar_DescripcionResultado() {
		int result=spock.comparar(papel);
		assertEquals("spock pierde con papel", spock.getDescriptionResultado());
	}
	
	@Test 
	void testSpockPierdeConLagartija(){
		assertEquals(-1, spock.comparar(lagartija));
	}
	@Test
	void testSpockPierdeConLagartija_comparar_DescripcionResultado() {
		int result=spock.comparar(lagartija);
		assertEquals("spock pierde con lagartija", spock.getDescriptionResultado());
	}
	
	@Test 
	void testSpockEmpataConSpock(){
		assertEquals(0, spock.comparar(spock));
	}
	@Test
	void testSpockEmpataConSpock_comparar_DescripcionResultado() {
		int result=spock.comparar(spock);
		assertEquals("spock empata con spock", spock.getDescriptionResultado());
	}
	
	@Test
	void testGetInstanceSpock() {
		assertEquals("spock", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.SPOCK)
								.getNombre());
	}
	
	
	@Test 
	void testLagartijaGanaASpock(){
		assertEquals(1, lagartija.comparar(spock));
	}
	@Test
	void testLagartijaGanaASpock_comparar_DescripcionResultado() {
		int result=lagartija.comparar(spock);
		assertEquals("lagartija le gana a spock", lagartija.getDescriptionResultado());
	}
	
	@Test 
	void testLagartijaGanaAPapel(){
		assertEquals(1, lagartija.comparar(papel));
	}
	@Test
	void testLagartijaGanaAPapel_comparar_DescripcionResultado() {
		int result=lagartija.comparar(papel);
		assertEquals("lagartija le gana a papel", lagartija.getDescriptionResultado());
	}
	
	@Test 
	void testLagartijaPierdeConTijera(){
		assertEquals(-1, lagartija.comparar(tijera));
	}
	@Test
	void testLagartijaPierdeConTijera_comparar_DescripcionResultado() {
		int result=lagartija.comparar(tijera);
		assertEquals("lagartija pierde con tijera", lagartija.getDescriptionResultado());
	}
	
	@Test 
	void testLagartijaPierdeConPiedra(){
		assertEquals(-1, lagartija.comparar(piedra));
	}
	@Test
	void testLagartijaPierdeConPiedra_comparar_DescripcionResultado() {
		int result=lagartija.comparar(piedra);
		assertEquals("lagartija pierde con piedra", lagartija.getDescriptionResultado());
	}
	
	@Test 
	void testLagartijaEmpataConLagartija(){
		assertEquals(0, lagartija.comparar(lagartija));
	}
	@Test
	void testLagartijaEmpataConLagartija_comparar_DescripcionResultado() {
		int result=lagartija.comparar(lagartija);
		assertEquals("lagartija empata con lagartija", lagartija.getDescriptionResultado());
	}
	
	@Test
	void testGetInstanceLagartija() {
		assertEquals("lagartija", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.LAGARTIJA)
								.getNombre());
	}
	

}
