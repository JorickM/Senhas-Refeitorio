<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\LoginController;
use App\Http\Controllers\WeekdayController;
use App\Http\Controllers\MealController;
use App\Http\Controllers\PurchaseController;


/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Auth::routes();

Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');
Route::get('/', [App\Http\Controllers\HomeController::class, 'index'])->name('home');

//Route::get('/', function () {
//    return view('welcome');
//});

Route::resource('logins', LoginController::class);
Route::resource('weekdays', WeekdayController::class);
Route::resource('meals', MealController::class);
Route::resource('purchases', PurchaseController::class);
//Route::get('logins/{codUser}/edit', LoginController::class);
//Route::get('/logins', LoginController::class, 'index');
