<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Meal extends Model
{
    use HasFactory;
    protected $table = 'logins';
    protected $fillable = ['codWeekday', 'mainDish', 'soup', 'desert', 'url'];

    public function weekday(){
        return $this->belongsTo(Weekdays::class);
    }

    public function purchases()
    {
        return $this->belongsToMany(Purchase::class);
    }
}
